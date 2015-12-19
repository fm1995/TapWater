<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="header">
		<div class="content_pad">
			<h1>
				<a href="/SyProject/SY/workspace.jsp">湖南省自来水公司营销管理信息系统</a>
			</h1>
			<ul id="nav">
				<li class="nav_dropdown nav_icon"><a href="javascript:;"><span
						class="ui-icon ui-icon-wrench"></span>业扩工程</a>
					<div class="nav_menu">
						<ul>
							<c:forEach items="${listMenu}" var="li">
								<c:if test="${li.syMenus.menuParent==30}">
									<li><a href="${li.syMenus.menuUrl}">${li.syMenus.menuName}</a></li>
								</c:if>
							</c:forEach>

						</ul>
					</div></li>
				<li class="nav_dropdown nav_icon"><a href="javascript:;"><span
						class="ui-icon ui-icon-person"></span>用户管理</a>
					<div class="nav_menu">
						<ul>
							<c:forEach items="${listMenu}" var="li">
								<c:if test="${li.syMenus.menuParent==45}">
									<li><a href="${li.syMenus.menuUrl}">${li.syMenus.menuName}</a></li>
								</c:if>
							</c:forEach>
						</ul>

					</div></li>

				<li class="nav_dropdown nav_icon"><a href="javascript:;"><span
						class="ui-icon ui-icon-pencil"></span>抄表管理</a>
					<div class="nav_menu">
						<ul>
							<c:forEach items="${listMenu}" var="li">
								<c:if test="${li.syMenus.menuParent==61}">
									<li><a href="${li.syMenus.menuUrl}">${li.syMenus.menuName}</a></li>
								</c:if>
							</c:forEach>

						</ul>
					</div></li>
				<li class="nav_dropdown nav_icon"><a href="javascript:;"><span
						class="ui-icon ui-icon-star"></span>收费管理</a>
					<div class="nav_menu">
						<ul>

							<c:forEach items="${listMenu}" var="li">
								<c:if test="${li.syMenus.menuParent==1}">
									<li><a href="${li.syMenus.menuUrl}">${li.syMenus.menuName}</a></li>
								</c:if>
							</c:forEach>

						</ul>

					</div></li>
				<li class="nav_dropdown nav_icon"><a href="javascript:;"><span
						class="ui-icon ui-icon-script"></span>发票管理</a>
					<div class="nav_menu">
						<ul>
							<c:forEach items="${listMenu}" var="li">
								<c:if test="${li.syMenus.menuParent==84}">
									<li><a href="${li.syMenus.menuUrl}">${li.syMenus.menuName}</a></li>
								</c:if>
							</c:forEach>
						</ul>
					</div></li>
				<li class="nav_dropdown nav_icon"><a href="javascript:;"><span
						class="ui-icon ui-icon-gear"></span>系统设置</a>
					<div class="nav_menu">
						<ul>
							<c:forEach items="${listMenu}" var="li">
								<c:if test="${li.syMenus.menuParent==73}">
									<li><a href="${li.syMenus.menuUrl}">${li.syMenus.menuName}</a></li>
								</c:if>
							</c:forEach>
						</ul>
					</div></li>
				<li class="nav_current nav_dropdown nav_icon_only"><a
					href="javascript:;">&nbsp;</a>
					<div class="nav_menu">
						<ul>
							<li><a href="/SyProject/iv/workSpceShow">我的工作台</a></li>
							<li><a href="/SyProject/SY/page/sys_pwd.jsp">修改密码</a></li>
							<li><a href="/SyProject/SY/login.jsp">退出系统</a></li>
						</ul>
					</div> <!-- .menu --></li>
			</ul>
		</div>
		<!-- .content_pad -->

	</div>