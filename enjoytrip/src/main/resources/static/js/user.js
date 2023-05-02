// 서버의 contextPath
let root = "";

// 로그인 유무 확인
// fetch(`${root}/user/islogin`)
//   .then((response) => response.json())
//   .then((data) => makenav(data));

// function makenav(check) {
//   console.log("userid : " + JSON.stringify(check));
//   if (check.userId == null) {
//     console.log("로그아웃");
//     document.querySelector("#login").setAttribute("style", "display: block;'");
//     document.querySelector("#join").setAttribute("style", "display: block;");
//     document.querySelector("#logout").setAttribute("style", "display: none;");
//     document
//       .querySelector("#admin-list")
//       .setAttribute("style", "display: none;");
//   } else if (check.userId == "admin") {
//     console.log("관리자 로그인");
//     document.querySelector("#login").setAttribute("style", "display: none;");
//     document.querySelector("#join").setAttribute("style", "display: none;");
//     document.querySelector("#logout").setAttribute("style", "display: block;");
//     document
//       .querySelector("#admin-list")
//       .setAttribute("style", "display: block;");
//   } else {
//     console.log("로그인");
//     document.querySelector("#login").setAttribute("style", "display: none;");
//     document.querySelector("#join").setAttribute("style", "display: none;");
//     document.querySelector("#logout").setAttribute("style", "display: block;");
//     document
//       .querySelector("#admin-list")
//       .setAttribute("style", "display: none;");
//   }
// }

// session storage에서 로그인 유뮤 확인
let userid = sessionStorage.getItem("userid");
let isadmin = sessionStorage.getItem("isadmin");
console.log("sessionStorage => userid: " + userid + " / isadmin: " + isadmin);
if (userid == null) {
  console.log("로그아웃");
  document.querySelector("#login").setAttribute("style", "display: block;'");
  document.querySelector("#join").setAttribute("style", "display: block;");
  document.querySelector("#logout").setAttribute("style", "display: none;");
  document.querySelector("#userinfo").setAttribute("style", "display: none;");
  document.querySelector("#admin-list").setAttribute("style", "display: none;");
} else if (isadmin == 1) {
  console.log("관리자 로그인");
  document.querySelector("#login").setAttribute("style", "display: none;");
  document.querySelector("#join").setAttribute("style", "display: none;");
  document.querySelector("#logout").setAttribute("style", "display: block;");
  document.querySelector("#userinfo").setAttribute("style", "display: none;");
  document
    .querySelector("#admin-list")
    .setAttribute("style", "display: block;");
} else {
  console.log("로그인");
  document.querySelector("#login").setAttribute("style", "display: none;");
  document.querySelector("#join").setAttribute("style", "display: none;");
  document.querySelector("#logout").setAttribute("style", "display: block;");
  document.querySelector("#userinfo").setAttribute("style", "display: block;");
  document.querySelector("#admin-list").setAttribute("style", "display: none;");
}

//회원 정보 가입
document.querySelector("#btn-join").addEventListener("click", function () {
  let registerinfo = {
    userName: document.querySelector("#username").value,
    userId: document.querySelector("#userid").value,
    userPwd: document.querySelector("#userpwd").value,
    emailId: document.querySelector("#emailid").value,
    emailDomain: document.querySelector("#emaildomain").value,
  };

  // POST 전송을 위한 설정
  let config = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(registerinfo),
  };
  console.log(config);
  fetch(`${root}/user/join`, config);
  window.location.reload();
});

// 회원 정보 조회
document.querySelector("#userinfo").addEventListener("click", function () {
  let userid = sessionStorage.getItem("userid");
  fetch(`${root}/user/${userid}`)
    .then((response) => response.json())
    .then((data) => userinfo(data));
});

function userinfo(user) {
  console.log(user);
  let info = `
      <div class="mb-3">
        <div><b>아이디 </b></div>
        <div>${user.userId}</div>
      </div>
      <div class="mb-3">
        <div><b>이름 </b></div>
        <div>${user.userName}</div>
      </div>
      <div class="mb-3">
        <div><b>비밀번호 </b></div>
        <div>${user.userPwd}</div>
      </div>
      <div class="mb-3">
        <div><b>이메일 </b></div>
        <div>${user.emailId}@${user.emailDomain}</div>
      </div>
  `;
  document.querySelector("#userinfolist").innerHTML = info;
}

// 회원 정보 수정
document
  .querySelector("#userinfoupdate")
  .addEventListener("click", function () {
    // // 회원 정보 안보이게
    let update = `
    <div class="mb-3">
      <div><b>아이디 </b></div>
       <div>${sessionStorage.getItem("userid")}</div>
    </div>
    <div class="mb-3">
      <div><b>비밀번호 </b></div>
      <div><input type="text" name="userpwd" id="newpwd"></div>
    </div>
    <div class="mb-3">
      <div><b>이메일 </b></div>
      <div><input type="text" name="useremail" id="newemailid"></div>
      <div>@</div>
      <div><input type="text" name="useremail" id="newemaildomain"></div>
    </div>
    `;
    document.querySelector("#userinfolist").innerHTML = update;
    document
      .querySelector("#userinfoupdate")
      .setAttribute("style", "display: none;");
    document
      .querySelector("#btn-update")
      .setAttribute("style", "display: block;");

    // POST 전송을 위한 설정
    document
      .querySelector("#btn-update")
      .addEventListener("click", function () {
        let registerinfo = {
          userName: null,
          userId: sessionStorage.getItem("userid"),
          userPwd: document.querySelector("#newpwd").value,
          emailId: document.querySelector("#newemailid").value,
          emailDomain: document.querySelector("#newemaildomain").value,
        };

        let config = {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(registerinfo),
        };
        fetch(`${root}/user/update`, config)
          .then((response) => response.json())
          .then((user) => userinfo(user));

        document
          .querySelector("#userinfoupdate")
          .setAttribute("style", "display: block;");
      });
  });

// 히원 정보 삭제(탈퇴)

// 로그인
document.querySelector("#btn-login").addEventListener("click", function () {
  let logininfo = {
    userId: document.querySelector("#login-userid").value,
    userPwd: document.querySelector("#login-userpwd").value,
  };

  let config = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(logininfo),
  };
  // console.log(config);
  fetch(`${root}/user/login`, config)
    .then((response) => response.json())
    .then((data) => storeInSession(data));

  window.location.reload();
});

// 세션 스토리지에 로그인 정보 저장
function storeInSession(data) {
  console.log("!!! " + data);
  sessionStorage.setItem("userid", data.userId);
  sessionStorage.setItem("isadmin", data.admin);
  console.log("저장된 유저 아이디: " + sessionStorage.getItem("userid"));
}

// 로그아웃
document.querySelector("#logout").addEventListener("click", function () {
  fetch(`${root}/user/logout`);
  sessionStorage.clear();
  window.location.reload();
});
