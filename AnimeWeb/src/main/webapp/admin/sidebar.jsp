<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="iq-sidebar">
	<div class="iq-navbar-logo d-flex justify-content-between">
		<a href="index.html" class="header-logo"> <img
			src="images/logo.png" class="img-fluid rounded" alt=""> <span>FinDash</span>
		</a>
		<div class="iq-menu-bt align-self-center">
			<div class="wrapper-menu">
				<div class="main-circle">
					<i class="ri-menu-line"></i>
				</div>
				<div class="hover-circle">
					<i class="ri-close-fill"></i>
				</div>
			</div>
		</div>
	</div>
	<div id="sidebar-scrollbar">
		<nav class="iq-sidebar-menu">
			<ul id="iq-sidebar-toggle" class="iq-menu">
				<li class="active"><a href="#dashboard" class="iq-waves-effect"
					data-toggle="collapse" aria-expanded="true"><span
						class="ripple rippleEffect"></span><i
						class="las la-home iq-arrow-left"></i><span>Dashboard</span><i
						class="ri-arrow-right-s-line iq-arrow-right"></i></a>
					<ul id="dashboard" class="iq-submenu collapse show"
						data-parent="#iq-sidebar-toggle">
						<li class="active"><a href="index.html"><i
								class="las la-laptop-code"></i>Account Dashboard</a></li>

					</ul></li>


				<li><a href="#userinfo" class="iq-waves-effect"
					data-toggle="collapse" aria-expanded="false"><span
						class="ripple rippleEffect"></span><i
						class="las la-user-tie iq-arrow-left"></i><span>User</span><i
						class="ri-arrow-right-s-line iq-arrow-right"></i></a>
					<ul id="userinfo" class="iq-submenu collapse"
						data-parent="#iq-sidebar-toggle" style="">
						<li><a href="UserEdit"><i class="las la-edit"></i>User
								Edit</a></li>
						<li><a href="UserAdd"><i class="las la-plus-circle"></i>User
								Add</a></li>
						<li><a href="UserList"><i class="las la-th-list"></i>User
								List</a></li>
					</ul></li>




				<li><a href="#charts" class="iq-waves-effect collapsed"
					data-toggle="collapse" aria-expanded="false"><i
						class="ri-pie-chart-box-line iq-arrow-left"></i><span>Charts</span><i
						class="ri-arrow-right-s-line iq-arrow-right"></i></a>
					<ul id="charts" class="iq-submenu collapse"
						data-parent="#iq-sidebar-toggle">

						<li><a href="Chart"><i
								class="ri-folder-chart-2-line"></i>Apex Chart</a></li>
					</ul></li>

				<li><a href="#authentication" class="iq-waves-effect collapsed"
					data-toggle="collapse" aria-expanded="false"><i
						class="ri-pages-line iq-arrow-left"></i><span>Authentication</span><i
						class="ri-arrow-right-s-line iq-arrow-right"></i></a>
					<ul id="authentication" class="iq-submenu collapse"
						data-parent="#iq-sidebar-toggle">
						<li><a href="sign-in.html"><i class="las la-sign-in-alt"></i>Login</a></li>
						<li><a href="sign-up.html"><i
								class="ri-login-circle-line"></i>Register</a></li>
						<li><a href="pages-recoverpw.html"><i
								class="ri-record-mail-line"></i>Recover Password</a></li>
						<li><a href="pages-confirm-mail.html"><i
								class="ri-file-code-line"></i>Confirm Mail</a></li>
						<li><a href="pages-lock-screen.html"><i
								class="ri-lock-line"></i>Lock Screen</a></li>
					</ul></li>

			</ul>
		</nav>
		<div class="p-3"></div>
	</div>
</div>