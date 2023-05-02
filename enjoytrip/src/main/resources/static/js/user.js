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

//회원 등록
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

