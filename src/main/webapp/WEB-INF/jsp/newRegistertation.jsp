<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Registration</h1>

	<form action="addUser" method="post" id="sign-up"
		enctype="multipart/form-data">

		<div class="row">

			<div class="col-md-4">

				<div class="form-group">

					<label class="bmd-label-floating">Role</label> <select
						class="form-control" name="role" id="role">
						<option>Admin</option>
						<option>User</option>
					</select>
				</div>
			</div>

			<div class="col-md-4">

				<div class="form-group">

					<label class="bmd-label-floating">First Name</label> <input
						type="text" class="form-control" name="firstName" id="firstName"
						maxlength="20">
				</div>
			</div>

		</div>

		<div class="row">
			<div class="col-md-4">
				<div class="form-group">
					<label class="bmd-label-floating">Email address</label> <input
						type="email" class="form-control" name="email" id="email"
						maxlength="64" required="true"> <span id=result
						style="color: red"> </span>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label class="bmd-label-floating">Password</label> <input
						type="password" class="form-control" name="password" id="password"
						required="true" maxlength="16">
				</div>
			</div>
			<!-- progress bar start  -->
			<div class="pwstrength_viewport_progress"></div>
			<!-- progress bar end -->


		</div>

		<div class="row">
			<div class="container-fluid">
				<label class="bmd-label-floating">Gender</label>
			</div>
		</div>

		<div class="row">
			<div class="container">
				<div class="col-md-4">
					<div class="form-group">
						<input type="radio" class="form-check-input" id="radio1"
							name="gender" value="Male" checked>Male
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<input type="radio" class="form-check-input" id="radio1"
							name="gender" value="Female">Female
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<input type="radio" class="form-check-input" id="radio1"
							name="gender" value="other">other
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="form-group">
					<label class="bmd-label-floating">Adress</label> <input type="text"
						class="form-control" name="address" id="address" required="true"
						maxlength="50">
				</div>
			</div>

			<div class="col-md-4">
				<div class="form-group"></div>
			</div>

			<div class="col-md-4">
				<div class="form-group">
					<label class="bmd-label-floating">Phone Number</label> <input
						type="text" class="form-control" name="phoneNumber"
						id="phoneNumber" required="true">
				</div>
			</div>
		</div>



		<div class="row">
			<div class="col-md-12">
				<div class="form-group"></div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-4">
				<label>Image Upload </label> <input name="multipartimage"
					id="img-upload-input" type="file" accept="image/*" required="true">
			</div>
		</div>



		<div class="row">
			<div class="col-md-12">
				<div class="form-group"></div>
				<button type="submit" id="ajaxStart"
					class="btn btn-primary pull-right">Add Profile</button>

				<%-- 										<h4>${error}</h4> --%>


				<label style="color: red;">${error}</label>


				<div class="clearfix"></div>

			</div>
		</div>

	</form>

</body>
</html>