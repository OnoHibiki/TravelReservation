// 予約データを取得して表示する関数（削除ボタン付き）
async function fetchReservations() {
  try {
      // APIから予約データを取得
      const response = await fetch('/reservations');
      if (!response.ok) throw new Error("予約データの取得に失敗しました");

      const reservations = await response.json();
      
      // HTMLに埋め込む
      const reservationsContainer = document.getElementById('reservations');
      reservationsContainer.innerHTML = ''; // 既存データをクリア

      reservations.forEach(reservation => {
          const div = document.createElement('div');
          div.className = 'reservation';
          div.innerHTML = `
              <h2>予約ID: ${reservation.id}</h2>
              <p>ユーザー名: ${reservation.user.name}</p>
              <p>旅行プラン: ${reservation.travelPlan.tourName} (${reservation.travelPlan.destination})</p>
              <p>予約日: ${reservation.reservedDate}</p>
              <p>支払いステータス: ${reservation.paymentStatus}</p>
              <button class="delete-btn" data-id="${reservation.id}">削除</button>
          `;
          reservationsContainer.appendChild(div);
      });

      // 削除ボタンのイベントを追加
      document.querySelectorAll(".delete-btn").forEach(button => {
          button.addEventListener("click", async (event) => {
              const id = event.target.getAttribute("data-id");
              await deleteReservation(id);
          });
      });

  } catch (error) {
      console.error('Error fetching reservations:', error);
      alert("予約データの取得に失敗しました。サーバーを確認してください。");
  }
}

// 特定の予約を削除する関数
async function deleteReservation(id) {
  if (!confirm("この予約を削除しますか？")) {
      return;
  }

  try {
      const response = await fetch(`/reservations/${id}`, {
          method: "DELETE"
      });

      if (response.ok) {
          alert("予約が削除されました");
          document.querySelector(`button[data-id="${id}"]`).parentElement.remove(); // 即時削除
      } else {
          throw new Error("削除に失敗しました");
      }
  } catch (error) {
      console.error("Error deleting reservation:", error);
      alert("削除に失敗しました。サーバーを確認してください。");
  }
}

// ページロード時にデータを取得
document.addEventListener('DOMContentLoaded', fetchReservations);
