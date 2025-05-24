document.addEventListener("DOMContentLoaded", async function () {
    // 검색창 toggle (기존 기능)
    const searchIcon = document.getElementById("search-icon");
    const searchContainer = document.getElementById("search-container");

    if (searchIcon && searchContainer) {
        searchIcon.addEventListener("click", () => {
            if (searchContainer.style.display === "none") {
                searchContainer.style.display = "block";
            } else {
                searchContainer.style.display = "none";
            }
        });
    }

    // 로그인 사용자 정보 출력
    const headerUser = document.getElementById("header-user");
    const logoutBtn = document.getElementById("logout-btn");

    try {
        const res = await fetch("/api/me");
        if (res.ok) {
            const data = await res.json();
            if (data.result === "success") {
                if (headerUser) {
                    headerUser.innerText = `${data.name}님 환영합니다!`;
                    headerUser.style.display = "inline";
                }
                if (logoutBtn) {
                    logoutBtn.style.display = "inline";
                }
            }
        }
    } catch (err) {
        console.error("세션 사용자 확인 실패:", err);
    }

    // 로그아웃 버튼 이벤트
    if (logoutBtn) {
        logoutBtn.addEventListener("click", async () => {
            try {
                const res = await fetch("/api/logout", { method: "POST" });
                if (res.ok) {
                    alert("로그아웃 되었습니다.");
                    window.location.href = "/";
                } else {
                    alert("로그아웃 실패!");
                }
            } catch (err) {
                alert("서버 오류 발생");
                console.error(err);
            }
        });
    }
});
