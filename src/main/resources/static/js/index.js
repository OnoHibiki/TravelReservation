document.addEventListener("DOMContentLoaded", async function () {
  const plansContainer = document.getElementById("plans-container");

  async function fetchTravelPlans() {
      try {
          const response = await fetch("/travel-plans");
          const plans = await response.json();

          plansContainer.innerHTML = ""; // 既存の内容をクリア

          plans.forEach(plan => {
              const planDiv = document.createElement("div");
              planDiv.className = "plan";
              planDiv.innerHTML = `
                  <h3>${plan.tourName}</h3>
                  <p><strong>行き先:</strong> ${plan.destination}</p>
                  <p><strong>価格:</strong> ${plan.price} 円</p>
                  <p><strong>出発日:</strong> ${plan.departureDate} ～ ${plan.returnDate}</p>
                  <p>${plan.description}</p>
              `;
              plansContainer.appendChild(planDiv);
          });

      } catch (error) {
          console.error("旅行プランの取得に失敗しました:", error);
      }
  }

  fetchTravelPlans();
});
