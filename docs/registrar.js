
let Registrar = async () => {
  let user = {};
  user.name = document.getElementById("name").value;
  user.email = document.getElementById("email").value;
  user.password = document.getElementById("pass").value;
  user.role = document.getElementById("role").value;

  const response = await fetch("http://localhost:8080/api/register", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(user),
  });

  const data = await response.json();
  document.getElementById("message").textContent = data.message;

  alert(data.message);
  if (data.success) {
    alert("Registro exitoso.");
    window.location.href = "login.html"; // Redirigir al login
  } else {
    window.location.href = "registrar.html";
  }
};
