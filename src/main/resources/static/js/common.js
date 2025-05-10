document.addEventListener('DOMContentLoaded', () => {
  const openBtn = document.getElementById('search-open-btn');
  const popupContainer = document.getElementById('search-container');

  if (openBtn && popupContainer) {
    openBtn.addEventListener('click', (e) => {
      e.preventDefault();
      fetch('/search')
      .then(res => res.text())
      .then(html => {
        popupContainer.innerHTML = html;
        popupContainer.style.display = 'block';

        const closeBtn = popupContainer.querySelector('#search-close-btn');
        if (closeBtn) {
          closeBtn.addEventListener('click', () => {
          popupContainer.style.display = 'none';
          });
        }
      });
    });
  }
});
