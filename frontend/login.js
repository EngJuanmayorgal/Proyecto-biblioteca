
let Login = async () => {
  let user = {};
  user.username = document.getElementById("username").value;
  user.password = document.getElementById("password").value;
  user.role = document.getElementById("role").value;
  const response = await fetch("http://localhost:8080/api/login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(user),
  });

  const data = await response.json();
  if (data.success) {
    if (user.role === "user") {
      window.location.href = "lector.html";
    } else if (user.role === "admin") {
      window.location.href = "admin.html";
    } 
  }else {
    alert("Credenciales incorrectas.");
    window.location.href="login.html";
  }
};
