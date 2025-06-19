Lector()
function Lector() {
    let lector = JSON.parse(localStorage.getItem("lector"));
    if (!lector) {
        window.location.href = "login.html";
    } else {
        document.getElementById("lectorNombre").textContent = " " + lector.name;
    }
}

// Expandir/Encoger Menú
function toggleSidebar() {
    document.getElementById("sidebar").classList.toggle("shrink");
}

// Ver datos del usuario
function verMisDatos() {
    let lector = JSON.parse(localStorage.getItem("lector"));

    let contenido = document.getElementById("contenido");

    contenido.style.display = "flex";
    contenido.style.justifyContent = "center";
    contenido.style.alignItems = "center";
    contenido.style.height = "100vh"; // Altura completa de la pantalla
    contenido.style.backgroundColor = "rgba(0, 0, 0, 0.4)"; // Fondo opcional semioscuro si quieres contraste

    if (!lector) {
        contenido.innerHTML = `
            <div style="
                background-color: rgba(255, 255, 255, 0.9);
                padding: 30px;
                border-radius: 15px;
                width: 80%;
                max-width: 500px;
                text-align: center;
                box-shadow: 0 0 10px rgba(0,0,0,0.3);
            ">
                <h3 style="font-size: 28px;">Mis Datos</h3>
                <p style="font-size: 20px;">No hay datos disponibles.</p>
            </div>
        `;
        return;
    }

    contenido.innerHTML = `
        <div style="
            background-color: rgba(255, 255, 255, 0.9);
            padding: 30px;
            border-radius: 15px;
            width: 80%;
            max-width: 500px;
            text-align: center;
            box-shadow: 0 0 10px rgba(0,0,0,0.3);
        ">
            <h3 style="font-size: 28px; margin-bottom: 20px;">Mis Datos</h3>
            <p style="font-size: 20px;"><strong>Nombre:</strong> ${lector.name}</p>
            <p style="font-size: 20px;"><strong>Email:</strong> ${lector.email}</p>
        </div>
    `;
}


// Ver libros disponibles
async function verLibros() {
    let lector = JSON.parse(localStorage.getItem("lector"));
    const response = await fetch(`http://localhost:8080/api/libros/id_lector?id_lector=${lector.id_lector}`);
    const libros = await response.json();
    const contenido = document.getElementById("contenido");

    // Estilo general del contenedor
    contenido.style.display = "flex";
    contenido.style.justifyContent = "center";
    contenido.style.alignItems = "center";
    contenido.style.height = "100vh";
    contenido.style.backgroundColor = "rgba(0, 0, 0, 0.4)";
    contenido.style.overflowY = "auto";
    contenido.style.padding = "20px";

    // Construcción del contenido HTML
    let html = `
        <div style="
            background-color: rgba(255, 255, 255, 0.95);
            padding: 30px;
            border-radius: 15px;
            width: 90%;
            max-width: 1000px;
            box-shadow: 0 0 10px rgba(0,0,0,0.3);
            font-size: 18px;
            color: #000;
        ">
            <h2 style="text-align: center; font-size: 28px; margin-bottom: 20px;">Libros Disponibles</h2>
            <div style="display: grid; grid-template-columns: repeat(auto-fill, minmax(250px, 1fr)); gap: 20px;">
    `;

    libros.forEach(libro => {
        html += `
            <div style="
                background-color: white;
                border: 1px solid #ccc;
                border-radius: 10px;
                padding: 15px;
                box-shadow: 2px 2px 8px rgba(0,0,0,0.1);
                display: flex;
                flex-direction: column;
                justify-content: space-between;
            ">
                <div>
                    <p><strong>Título:</strong> ${libro.titulo}</p>
                    <p><strong>Autor:</strong> ${libro.autor}</p>
                    <p><strong>Género:</strong> ${libro.genero}</p>
                    <p><strong>Año de publicación:</strong> ${libro.año_publi}</p>
                    <p><strong>ISBN:</strong> ${libro.isbn}</p>
                    <p><strong>Unidades disponibles:</strong> ${libro.unidDispo}</p>
                </div>
                <button class="btn-prestamo" data-titulo="${libro.titulo}" data-id_lib="${libro.id_libro}" 
                data-unid_dispo="${libro.unidDispo}" style="
                    margin-top: 10px;
                    background-color: #3498db;
                    color: white;
                    border: none;
                    padding: 10px;
                    border-radius: 5px;
                    cursor: pointer;
                    font-weight: bold;
                ">
                    Pedir prestado
                </button>
            </div>
        `;
    });

    html += `
            </div>
        </div>
    `;

    contenido.innerHTML = html;
    // Esperar al DOM
    setTimeout(() => {
        const botones = document.querySelectorAll(".btn-prestamo");
        botones.forEach(boton => {
            boton.addEventListener("click", () => {
                const tituloLibro = boton.getAttribute("data-titulo");
                const idLibro = boton.getAttribute("data-id_lib");
                const unidDispo = boton.getAttribute("data-unid_dispo");
                pedirPrestado(tituloLibro, idLibro, unidDispo);
            });
        });
    }, 0);

}
function pedirPrestado(titulo, id_libro, unidDispo) {
    alert("Has solicitado el préstamo del libro : " + titulo);

    // Puedes hacer fetch POST aquí si quieres guardar el préstamo
    // Ejemplo:
    let lector = JSON.parse(localStorage.getItem("lector"));
    let libro = {
        id_libro: parseInt(id_libro),
        fecha_prestamo: " " + new Date().toISOString().split('T')[0],
        fecha_devolucion: " " + new Date(new Date().setDate(new Date().getDate() + 7)).toISOString().split('T')[0],
        lector: {
            id_lector: lector.id_lector,
        }
    };
    fetch("http://localhost:8080/api/prestamo", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ libro })
    }).then(resp => {
        if (resp.ok) alert("Préstamo registrado exitosamente");
        else alert("Error al registrar el préstamo");
    });
    verLibros(); // Actualizar la lista de libros después del préstamo
}


// Ver préstamos
async function verPrestamos() {
    let lector = JSON.parse(localStorage.getItem("lector"));
    const response = await fetch(`http://localhost:8080/api/prestamos/id_lector?id_lector=${lector.id_lector}`);
    const prestamos = await response.json();

    let html = `
        <div style="display: flex; justify-content: center; align-items: center; min-height: 100vh;">
            <div style="background-color: rgba(255,255,255,0.95); padding: 30px; border-radius: 15px; width: 90%; max-width: 900px; font-size: 18px; box-shadow: 0 0 10px rgba(0,0,0,0.2);">
                <h2 style="text-align: center; margin-bottom: 25px;">📚 Mis Préstamos</h2>
    `;

    if (prestamos.length === 0) {
        html += `<p style="text-align: center;">No tienes préstamos activos.</p>`;
    } else {
        html += `<div style="display: flex; flex-direction: column; gap: 20px;">`;
        prestamos.forEach(prestamo => {
            html += `
                <div style="border: 1px solid #ddd; border-radius: 10px; padding: 20px; background-color: #ffffffee; display: flex; justify-content: space-between; align-items: center;">
                    <div>
                        <strong>${prestamo.titulo}</strong><br>
                        📅 Retirado: ${prestamo.fechaRetiro}<br>
                        🗓️ Devolución: ${prestamo.fechaEntrega}
                    </div>
                    <button onclick="devolverLibro('${prestamo.idPrestamo}', '${prestamo.idLibro}')" style="padding: 10px 15px; background-color: #e74c3c; color: white; border: none; border-radius: 8px; cursor: pointer; font-size: 16px;">
                        🔄 Devolver
                    </button>
                </div>
            `;
        });
        html += `</div>`;
    }

    html += `</div></div>`;
    document.getElementById("contenido").innerHTML = html;
}


// Devolver libro
async function devolverLibro(prestamoId, idLibro) {
    alert("Has solicitado la devolución del libro con ID: " + idLibro + " y préstamo ID: " + prestamoId);
    const response = await fetch(`http://localhost:8080/api/devolver?id_prestamo=${prestamoId}&idLibro=${idLibro}`, {
        method: "GET"
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
