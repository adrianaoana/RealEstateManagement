<nav class="navbar navbar-default navbar-static-top" role="navigation"
	style="margin-bottom: 0">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="${CONTEXT_PATH}/">Real Estate
			Management</a>
	</div>
	<!-- /.navbar-header -->
	<ul class="nav navbar-top-links navbar-left">
		<li><a href="${CONTEXT_PATH}/offers?type=sales">Sales</a></li>
		<li><a href="${CONTEXT_PATH}/offers?type=rentals">Rentals</a></li>
	</ul>
	<ul class="nav navbar-top-links navbar-right">
		<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i
					class="fa fa-newspaper-o fa-fw"></i> <i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-alerts">
					<li><a href="${CONTEXT_PATH}/user/favorites"> <i
							class="fa fa-star-half-o fa-fw"></i> Favorites
					</a></li>
					<li class="divider"></li>
					<li><a href="${CONTEXT_PATH}/user/ads"> <i
							class="fa fa-list-alt fa-fw"></i> My ads
					</a></li>
				</ul> <!-- /.dropdown-alerts --></li>
			<!-- /.dropdown -->
		</security:authorize>
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
				<i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-user">
				<!-- If not logged in, display login & ajax login links -->
				<security:authorize access="!hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
					<li><a href="#modalLogin" id="modal_trigger_login"><i
							class="fa fa-sign-in fa-fw"></i> Login</a>
					<li><a id="modal_trigger_register" href="#modalRegister">
							<i class="fa fa-user-plus fa-fw"></i> Sign Up
					</a>
				</security:authorize>
				<!-- If logged in, display secure and logout link -->
				<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
					<li><a href="${CONTEXT_PATH}/user"><i
							class="fa fa-user fa-fw"></i> My profile</a></li>
					<li><a href="${CONTEXT_PATH}/user/settings"><i
							class="fa fa-gear fa-fw"></i> Settings</a></li>
					<li class="divider"></li>
					<li><a href="${CONTEXT_PATH}/logout"><i
							class="fa fa-sign-out fa-fw"></i> Logout</a></li>
				</security:authorize>

			</ul> <!-- /.dropdown-user --></li>
		<!-- /.dropdown -->
	</ul>
	<!-- /.navbar-top-links -->
	<div id="modalLogin" class="popupContainer" style="display: none;">
		<header class="popupHeader">
			<span class="header_title">Login</span> <span class="modal_close"><i
				class="fa fa-times"></i> </span>
		</header>
		<section class="popupBody">
			<span class="error"></span>
			<!-- Register Form -->
			<div class="user_login">
				<form id="login" autocomplete="off">
					<div class='inputLogin'>
						<label for="email"><span class="fa fa-user fa-fw"></span></label>
						<input type="email" name="email" id="emailLogin"
							required="required" placeholder="E-mail address"
							autocomplete="off" readonly
							onfocus="this.removeAttribute('readonly');">
					</div>
					<div class='inputLogin'>
						<label for="password"><span class="fa fa-key fa-fw"></span></label>
						<input type="password" name="password" id="passwordLogin"
							pattern=".{6,20}" required="required" placeholder="Password"
							autocomplete="off" readonly
							onfocus="this.removeAttribute('readonly');">
					</div>
					<input type="submit" value="Login" /> <br />
				</form>
			</div>
		</section>
	</div>
	<div id="modalRegister" class="popupContainer" style="display: none;">
		<header class="popupHeader">
			<span class="header_title">Sign Up</span> <span class="modal_close"><i
				class="fa fa-times"></i></span>
		</header>
		<section class="popupBody">
			<span class="error"></span>
			<!-- Register Form -->
			<div class="user_register">
				<form:form id="register" modelAttribute="user">
					<div class="row">
						<div class="col-lg-6">
							<label>E-mail address</label>
							<form:input type="email" path="email" id="emailRegister"
								required="required" autocomplete="off"
								placeholder="E-mail address" readonly="true"
								onfocus="this.removeAttribute('readonly');" />
						</div>
						<div class="col-lg-6">
							<label>Password</label>
							<form:input type="password" path="password" id="passwordRegister"
								pattern=".{6,20}" required="required" placeholder="Password"
								autocomplete="off" readonly="true"
								onfocus="this.removeAttribute('readonly');" />
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<label>First Name</label>
							<form:input type="text" path="firstName" id="firstNameRegister"
								placeholder="Nume" />
						</div>
						<div class="col-lg-6">
							<label>Last Name</label>
							<form:input type="text" path="lastName" id="lastNameRegister"
								placeholder="Prenume" />
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<label>Country</label>
							<form:select path="country" id="countryRegister"
								class="dropdown-select" required="required" title="Tara"
								autocomplete="off">
								<option value="">- Select -</option>
								<option value="Romania">Romania</option>
								<option value="Germania">Germania</option>
								<option value="Franta">Franta</option>
								<option value="Belgia">Belgia</option>
								<option value="Bulgaria">Bulgaria</option>
								<option value="Olanda">Olanda</option>
								<option value="Spania">Spania</option>
								<option value="Italia">Italia</option>
								<option value="SUA">SUA</option>
								<option value="Marea Britanie">Marea Britanie</option>
								<option value="Danemarca">Danemarca</option>
								<option value="Irlanda">Irlanda</option>
								<option value="Austria">Austria</option>
								<option value="Canada">Canada</option>
								<option value="Suedia">Suedia</option>
								<option value="Ungaria">Ungaria</option>
								<option value="Cehia">Cehia</option>
								<option value="Luxemburg">Luxemburg</option>
								<option value="Polonia">Polonia</option>
								<option value="Grecia">Grecia</option>
								<option value="Slovenia">Slovenia</option>
								<option value="Estonia">Estonia</option>
								<option value="Strainatate">Strainatate</option>
							</form:select>
						</div>
						<div class="col-lg-6">
							<label>District</label>
							<div class="dropdown-dark">
								<form:select path="district" id="districtRegister"
									class="dropdown-select" title="District" autocomplete="off">
									<option value="">- Select -</option>
								</form:select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<label>City</label>
							<form:input type="text" path="city" id="cityRegister"
								placeholder="City" />
						</div>
						<div class="col-lg-6">
							<label>Phone</label>
							<form:input type="text" path="phone" id="phoneRegister"
								placeholder="Phone" minlength="10" maxlength="13" />
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<label>Street</label>
							<form:input type="text" path="street" id="streetRegister"
								placeholder="Street" />
						</div>
						<div class="col-lg-6">
							<label>Street number</label>
							<form:input type="text" path="streetNr" id="streetNrRegister"
								placeholder="Street number" />
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<input type="submit" value="Register" />
						</div>
					</div>

				</form:form>
			</div>
		</section>
	</div>
	<!-- /.navbar-static-side -->
</nav>
