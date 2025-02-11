document.addEventListener("DOMContentLoaded", async function () {
    const userSelect = document.getElementById("user");
    const travelPlanSelect = document.getElementById("travelPlan");
    const form = document.getElementById("reservation-form");
    const message = document.getElementById("message");
  
    // ユーザー一覧取得
    async function fetchUsers() {
      const response = await fetch("/users");
      const users = await response.json();
      users.forEach(user => {
        const option = document.createElement("option");
        option.value = user.id;
        option.textContent = user.name;
        userSelect.appendChild(option);
      });
    }
  
    // 旅行プラン一覧取得
    async function fetchTravelPlans() {
      const response = await fetch("/travel-plans");
      const travelPlans = await response.json();
      travelPlans.forEach(plan => {
        const option = document.createElement("option");
        option.value = plan.id;
        option.textContent = `${plan.tourName} - ${plan.destination} (${plan.price}円)`;
        travelPlanSelect.appendChild(option);
      });
    }
  
    // フォーム送信処理
    form.addEventListener("submit", async function (event) {
      event.preventDefault();
  
      const reservationData = {
        userId: parseInt(userSelect.value, 10), // 数値変換
        travelPlanId: parseInt(travelPlanSelect.value, 10), // 数値変換
        reservedDate: document.getElementById("reservedDate").value,
        paymentStatus: document.getElementById("paymentStatus").value
      };
  
      const response = await fetch("/reservations", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(reservationData)
      });
  
      if (response.ok) {
        message.textContent = "予約が完了しました！";
        message.style.color = "green";
        form.reset();
      } else {
        message.textContent = "予約に失敗しました。";
        message.style.color = "red";
      }
    });
  
    // 初期データ取得
    await fetchUsers();
    await fetchTravelPlans();
  });
  