application = {};
application.getContext = function() {
	var base = document.getElementsByTagName('base')[0];
	if (base && base.href && (base.href.length > 0)) {
		base = base.href;
	} else {
		base = document.URL;
	}
	// return base.substr(0, base.indexOf("/", base.indexOf("/", base
	// .indexOf("//") + 2) + 1));
	return "";
};

$(document).ready(function() {
	$("[rel='tooltip']").tooltip();

	$('.view').hover(function() {
		$(this).find('.caption').slideDown(250); // .fadeIn(250)
	}, function() {
		$(this).find('.caption').slideUp(250); // .fadeOut(205)
	});
});
$("#modal_trigger_login").leanModal({
	top : 50,
	overlay : 0.6,
	closeButton : ".modal_close"
});
$("#modal_trigger_register").leanModal({
	top : 10,
	overlay : 0.6,
	closeButton : ".modal_close"
});

$(function() {
	$(document).on('click', '#addAdLogin', function() {
		$('#modal_trigger_login').click();
		$('.error').html('You need to login first!');
		$('.error').show();
		return true;
	});
	$(document).on('click', '#modal_trigger_register', function() {
		$(".error").hide();
		$('#modalLogin').hide('slow');
		return true;
	});
	$(document).on('click', '#modal_trigger_login', function() {
		$(".error").hide();
		$('#modalRegister').hide('slow');
		return true;
	});

	$("#login").submit(
			function() {
				console.log("login");
				var username = $("#emailLogin").val();
				var password = $("#passwordLogin").val();
				var url = application.getContext() + '/login';
				// var data = $(this).serializeObject();

				$.ajax({
					url : url,
					type : 'POST',
					data : {
						'username' : username,
						'password' : password
					},
					datatype : 'json',
					success : function(data, textStatus) {
						if (data.success) {
							$('#lean_overlay').click();
							// $(".user_login").hide();
							if (data.targetUrl != null
									&& data.targetUrl != 'undefined'
									&& data.targetUrl != '') {
								location.href = application.getContext()
										+ data.targetUrl;
								reset();
							}
						} else {
							$('.error').html('Login failed!');
							$('.error').show();
							reset();
						}
					},
					error : function(xhr, textStatus, errorThrown) {
						$(".error").text(
								'Something went wrong.Please try again later');
						reset();
					}

				});

				return false;
			});
});

function reset() {
	$("#login")[0].reset();
	$("#register")[0].reset();
}
$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};
// ------------register
$(function() {
	$("#register")
			.submit(
					function() {

						console.log("register");

						var email = $("#emailRegister").val();
						var password = $("#passwordRegister").val();
						var url = application.getContext() + '/register';
						// var data = $(this).serializeObject();

						$
								.ajax({
									url : url,
									type : 'POST',
									data : {
										'email' : email,
										'password' : password,
										'firstName' : $("#firstNameRegister")
												.val(),
										'lastName' : $("#lastNameRegister")
												.val(),
										'country' : $("#countryRegister").val(),
										'district' : $("#districtRegister")
												.val(),
										'city' : $("#cityRegister").val(),
										'phone' : $("#phoneRegister").val(),
										'street' : $("#streetRegister").val(),
										'streetNr' : $("#streetNrRegister")
												.val()
									},
									datatype : 'json',
									success : function(data, textStatus) {
										if (data.success) {
											$('#lean_overlay').click();
											if (data.targetUrl != null
													&& data.targetUrl != 'undefined'
													&& data.targetUrl != '') {
												location.href = application
														.getContext()
														+ data.targetUrl;
											}
										} else {
											console.log(data.errors);

											// $("#register").attr("status",
											// data.user);
											$('.error').html(data.errors);
											$('.error').show();
											// $(".error").text(errorInfo);
										}

									},
									error : function(xhr, textStatus,
											errorThrown) {
										console.log("big error");
										$(".error")
												.text(
														'Something wen wrong. Please try again later.');
										reset();
									}

								});

						return false;
					});

	$("select#countryRegister").change(function() {
		var options = getDistricts($(this).val());
		$("select#districtRegister").html(options);
	});
	$("select#countrySelect").change(function() {
		var options = getDistricts($(this).val());
		$("select#districtSelect").html(options);
	});

	$("#changePassword").click(
			function() {
				var password = $("#newPassword1").val();
				if (password.length < 6 || !password.length >= 20) {
					$("#messageChangePassword").html("Invalid password");
					if ($('#messageChangePassword').hasClass("alert-success")) {
						$("#messageChangePassword")
								.removeClass("alert-success").addClass(
										"alert-danger");
					} else {
						$("#messageChangePassword").addClass(
								"alert alert-danger");
					}

					$("#messageChangePassword").show();
					return;
				}
				var valid = password == $("#newPassword2").val();
				if (!valid) {
					$("#messageChangePassword").html("Invalid password");
					if ($('#messageChangePassword').hasClass("alert-success")) {
						$("#messageChangePassword")
								.removeClass("alert-success").addClass(
										"alert-danger");
					} else {
						$("#messageChangePassword").addClass(
								"alert alert-danger");
					}

					$("#messageChangePassword").show();
					return;
				}
				var url = application.getContext()
						+ "/user/change-password?password=" + password;
				$.ajax({
					url : encodeURI(url),
					type : "post",
					beforeSend : function(xhr) {
						xhr.setRequestHeader("Accept", "application/json");
						xhr
								.setRequestHeader("Content-Type",
										"application/json");
					},
					success : function(data) {
						$("#messageChangePassword").html(
								"The password was successfully changed");
						if ($('#messageChangePassword')
								.hasClass("alert-danger")) {
							$("#messageChangePassword").removeClass(
									"alert-danger").addClass("alert-success");
						} else {
							$("#messageChangePassword").addClass(
									"alert alert-success");
						}
						$("#messageChangePassword").show();
					},
					error : function(xhr, textStatus, errorThrown) {
						console.log("error");
					}
				});

			});
});
function getDistricts(country) {
	var options = '<option value = "">- Select -</option>';
	if (country == 'Romania') {
		list = [ 'Alba', 'Arad', 'Arges', 'Bacau', 'Bihor', 'Bistrita Nasaud',
				'Botosani', 'Braila', 'Brasov', 'BUCURESTI', 'Buzau',
				'Calarasi', 'Caras Severin', 'Cluj', 'Constanta', 'Covasna',
				'Dambovita', 'Dolj', 'Galati', 'Giurgiu', 'Gorj', 'Harghita',
				'Hunedoara', 'Ialomita', 'Iasi', 'Ilfov', 'Maramures',
				'Mehedinti', 'Mures', 'Neamt', 'Olt', 'Prahova', 'Salaj',
				'Satu Mare', 'Sibiu', 'Suceava', 'Teleorman', 'Timis',
				'Tulcea', 'Valcea', 'Vaslui', 'Vrancea' ];
		for (var i = 0; i < list.length; i++) {
			options += '<option value = "' + list[i] + '" > ' + list[i]
					+ ' </option>';
		}
	}
	if (country == 'Germania') {
		list = [ 'Baden-Wurttemberg', 'Bayern', 'Berlin', 'Brandenburg',
				'Bremen', 'Hamburg', 'Hessen', 'Mecklenburg', 'Niedersachsen',
				'Nordrhein-Westfalen', 'Rheinland-Pfalz', 'Saarland',
				'Sachsen', 'Sachsen-Anhalt', 'Schleswig-Holstein', 'Thuringen' ];
		for (var i = 0; i < list.length; i++) {
			options += '<option value = "' + list[i] + '" > ' + list[i]
					+ ' </option>';
		}
	}
	return options;
}