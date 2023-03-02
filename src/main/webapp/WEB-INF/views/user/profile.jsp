<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<!--프로필 섹션-->
<section class="profile">
	<!--유저정보 컨테이너-->
	<div class="profileContainer">

		<!--유저이미지-->
		<div class="profile-left">
			<div class="profile-img-wrap story-border"
				onclick="popup('.modal-image')">
				<form id="userProfileImageForm">
					<input type="file" name="profileImageFile" style="display: none;"
						id="userProfileImageInput" />
				</form>

				<img class="profile-image" src="#"
					onerror="this.src='/images/person.jpeg'" id="userProfileImage" />
			</div>
		</div>
		<!--유저이미지end-->

		<!--유저정보 및 사진등록 구독하기-->
		<div class="profile-right">
			<div class="name-group">
				<h2>${dto.user.name}</h2>
				<c:choose>
					<c:when test="${dto.pageOwnerStatus}">
						<button class="cta" onclick="location.href='/image/upload'">사진등록</button>
					</c:when>
					<c:otherwise>
						<button class="cta" onclick="toggleSubscribe(this)">구독하기</button>
					</c:otherwise>
				</c:choose>
				<button class="modi" onclick="popup('.modal-info')">
					<i class="fas fa-cog"></i>
				</button>
			</div>

			<div class="subscribe">
				<ul>
					<li><a href=""> 게시물<span>${dto.imageCount }</span>
					</a></li>
					<li><a href="javascript:subscribeInfoModalOpen();"> 구독정보<span>2</span>
					</a></li>
				</ul>
			</div>
			<div class="state">
				<h4>${dto.user.bio }</h4>
				<h4>${dto.user.website }</h4>
			</div>
		</div>
		<!--유저정보 및 사진등록 구독하기-->

	</div>
</section>

<!--게시물컨섹션-->
<section id="tab-content">
	<!--게시물컨컨테이너-->
	<div class="profileContainer">
		<!--그냥 감싸는 div (지우면이미지커짐)-->
		<div id="tab-1-content" class="tab-content-item show">
			<!--게시물컨 그리드배열-->
			<div class="tab-1-content-inner">

				<!--아이템들-->

			<c:forEach var="image" items="${dto.user.images }"> <!-- EL 표현식에서 변수명을 적음녀 get함수가 자동 호출 -->
				<div class="img-box">
					<a href=""> <img src="/upload/${image.postImageUrl }" /> <!-- image를 따라감 -->
					</a>
					<div class="comment">
						<a href="#" class=""> <i class="fas fa-heart"></i><span>0</span>
						</a>
					</div>
				</div>
			</c:forEach>
				


				<!--아이템들end-->
			</div>
		</div>
	</div>
</section>

<!--로그아웃, 회원정보변경 모달-->
<div class="modal-info" onclick="modalInfo()">
	<div class="modal">
		<button onclick="location.href='/user/1/update'">회원정보 변경</button>
		<button onclick="location.href='/logout'">로그아웃</button>
		<button onclick="closePopup('.modal-info')">취소</button>
	</div>
</div>
<!--로그아웃, 회원정보변경 모달 end-->

<!--프로필사진 바꾸기 모달-->
<div class="modal-image" onclick="modalImage()">
	<div class="modal">
		<p>프로필 사진 바꾸기</p>
		<button onclick="profileImageUpload()">사진 업로드</button>
		<button onclick="closePopup('.modal-image')">취소</button>
	</div>
</div>

<!--프로필사진 바꾸기 모달end-->

<div class="modal-subscribe">
	<div class="subscribe">
		<div class="subscribe-header">
			<span>구독정보</span>
			<button onclick="modalClose()">
				<i class="fas fa-times"></i>
			</button>
		</div>

		<div class="subscribe-list" id="subscribeModalList">

			<div class="subscribe__item" id="subscribeModalItem-1">
				<div class="subscribe__img">
					<img src="#" onerror="this.src='/images/person.jpeg'"/>
				</div>
				<div class="subscribe__text">
					<h2>love</h2>
				</div>
				<div class="subscribe__btn">
					<button class="cta blue" onclick="toggleSubscribeModal(this)">구독취소</button>
				</div>
			</div>


			<div class="subscribe__item" id="subscribeModalItem-2">
				<div class="subscribe__img">
					<img src="#" onerror="this.src='/images/person.jpeg'"/>
				</div>
				<div class="subscribe__text">
					<h2>ssar</h2>
				</div>
				<div class="subscribe__btn">
					<button class="cta blue" onclick="toggleSubscribeModal(this)">구독취소</button>
				</div>
			</div>
		</div>
	</div>

</div>


<script src="/js/profile.js"></script>

<%@ include file="../layout/footer.jsp"%>