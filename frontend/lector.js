Lector()
function Lector(){
   let lector = JSON.parse(localStorage.getItem("lector"));
    if (!lector) {
        window.location.href = "login.html";
    } else {
        document.getElementById("lectorNombre").textContent =" "+ lector.name;
    }
}

// Expandir/Encoger Menú
function toggleSidebar() {
    document.getElementById("sidebar").classList.toggle("shrink");
}

// Ver datos del usuario
function verMisDatos() {
    let lector = JSON.parse(localStorage.getItem("lector"));
    document.getElementById("contenido").innerHTML = `
        <h3>Mis Datos</h3>
        <p><strong>Nombre:</strong> ${lector.name}</p>
        <p><strong>Email:</strong> ${lector.email}</p>
        <p><strong>Rol:</strong> lector</p>
    `;
}

// Ver libros disponibles
async function verLibros() {
    const response = await fetch("http://localhost:8080/api/libros");
    const libros = await response.json();

    let html = "<h3>Libros Disponibles</h3><ul>";
    libros.forEach(libro => {
        html += `<li>${libro.titulo} - ${libro.autor}</li>`;
    });
    html += "</ul>";

    document.getElementById("contenido").innerHTML = html;
}

// Ver préstamos
async function verPrestamos() {
    let lector = JSON.parse(localStorage.getItem("lector"));

    const response = await fetch(`http://localhost:8080/api/prestamos/${lector.email}`);
    const prestamos = await response.json();

    let html = "<h3>Mis Préstamos</h3>";
    if (prestamos.length === 0) {
        html += "<p>No tienes préstamos activos.</p>";
    } else {
        prestamos.forEach(prestamo => {
            html += `
                <p><strong>${prestamo.libro.titulo}</strong> - Prestado el ${prestamo.fechaPrestamo}</p>
                <button onclick="devolverLibro(${prestamo.id})">🔄 Devolver</button>
            `;
        });
    }

    document.getElementById("contenido").innerHTML = html;
}

// Devolver libro
async function devolverLibro(prestamoId) {
    const response = await fetch(`http://localhost:8080/api/prestamos/devolver/${prestamoId}`, {
        method: "PUT"
    });

    const data = await response.json();
    alert(data.message);
    verPrestamos();
}

// Cerrar sesión
function cerrarSesion() {
    localStorage.removeItem("lector");
    window.location.href = "login.html";
}
