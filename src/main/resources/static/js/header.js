document.addEventListener('DOMContentLoaded', async () => {
  console.log('header.js 실행됨!');

  const headerUser = document.getElementById('header-user');
  const logoutBtn = document.getElementById('logout-btn');
  const loginLink = document.getElementById('login-link');
  const cartLink = document.getElementById('cart-link');

  try {
    const res = await fetch('/api/me', { credentials: 'include' });
    const data = await res.json();

    if (data.result === 'success') {
      if (headerUser) {
        headerUser.innerText = `${data.name}님 환영합니다!`;
        headerUser.style.display = 'inline';
      }
      if (logoutBtn) {
        logoutBtn.style.display = 'inline';
        logoutBtn.addEventListener('click', async (e) => {
          e.preventDefault();
          await fetch('/api/logout', { method: 'POST' });
          alert('로그아웃 되었습니다.');
          location.reload();
        });
      }
      if (loginLink) loginLink.style.display = 'none';
    } else {
      if (headerUser) headerUser.style.display = 'none';
      if (logoutBtn) logoutBtn.style.display = 'none';
      if (loginLink) loginLink.style.display = 'inline';

      if (cartLink) {
        cartLink.addEventListener('click', (e) => {
          e.preventDefault();
          alert('로그인 후 이용해주세요!');
        });
      }
    }
  } catch (err) {
    console.error('헤더 로그인 확인 오류:', err);
  }
});
