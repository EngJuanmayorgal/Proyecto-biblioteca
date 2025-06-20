function toggleSidebar() {
  document.getElementById("sidebar").classList.toggle("shrink");
}

async function mostrarUsuarios() {
  const response = await fetch("http://localhost:8080/api/usuarios");
  const usuarios = await response.json();

  let html = `
    <div style="display: flex; justify-content: center; align-items: center; min-height: 100vh;">
      <div style="background-color: rgba(255,255,255,0.95); padding: 30px; border-radius: 15px; width: 90%; max-width: 900px; font-size: 18px; box-shadow: 0 0 10px rgba(0,0,0,0.2);">
        <h2 style="text-align: center; margin-bottom: 25px;">👥 Lista de Usuarios</h2>
        <div style="display: grid; grid-template-columns: repeat(auto-fill, minmax(250px, 1fr)); gap: 20px;">
  `;

  usuarios.forEach(u => {
    html += `
      <div style="border: 1px solid #ccc; border-radius: 10px; padding: 15px; background-color: #ffffffee;">
        <strong>📛 ${u.name}</strong><br>
        📧 ${u.email}
      </div>
    `;
  });

  html += `
        </div>
      </div>
    </div>
  `;

  document.getElementById("contenido").innerHTML = html;
}


// Ver libros con opciones
async function verLibros() {
  const response = await fetch("http://localhost:8080/api/todos los libros");
  const libros = await response.json();

  let html = `
    <div style="display: flex; justify-content: center; align-items: center; min-height: 100vh;">
      <div style="background-color: rgba(255,255,255,0.95); padding: 30px; border-radius: 15px; width: 95%; max-width: 1200px; box-shadow: 0 0 10px rgba(0,0,0,0.2);">
        <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px;">
          <h2 style="margin: 0;">📚 Libros</h2>
          <button onclick="formularioLibro()" style="padding: 10px 15px; font-size: 16px; border: none; background-color: #2ecc71; color: white; border-radius: 8px; cursor: pointer;">➕ Agregar Libro</button>
        </div>
        <table style="width: 100%; border-collapse: collapse; font-size: 16px;">
          <thead>
            <tr style="background-color: #f2f2f2;">
              <th style="padding: 10px; border: 1px solid #ccc;">Título</th>
              <th style="padding: 10px; border: 1px solid #ccc;">Editorial</th>
              <th style="padding: 10px; border: 1px solid #ccc;">Autor</th>
              <th style="padding: 10px; border: 1px solid #ccc;">ISBN</th>
              <th style="padding: 10px; border: 1px solid #ccc;">Año</th>
              <th style="padding: 10px; border: 1px solid #ccc;">Género</th>
              <th style="padding: 10px; border: 1px solid #ccc;">Unidades</th>
              <th style="padding: 10px; border: 1px solid #ccc;">Acciones</th>
            </tr>
          </thead>
          <tbody>
  `;

  libros.forEach(libro => {
    html += `
      <tr>
        <td style="padding: 8px; border: 1px solid #ccc;">${libro.titulo}</td>
        <td style="padding: 8px; border: 1px solid #ccc;">${libro.editorial}</td>
        <td style="padding: 8px; border: 1px solid #ccc;">${libro.autor}</td>
        <td style="padding: 8px; border: 1px solid #ccc;">${libro.isbn}</td>
        <td style="padding: 8px; border: 1px solid #ccc;">${libro.año_publi}</td>
        <td style="padding: 8px; border: 1px solid #ccc;">${libro.genero}</td>
        <td style="padding: 8px; border: 1px solid #ccc;">${libro.unidDispo}</td>
        <td style="padding: 8px; border: 1px solid #ccc; text-align: center;">
          <button onclick='formularioLibro(${JSON.stringify(libro)})' style="padding: 5px 10px; font-size: 14px; background-color: #f1c40f; border: none; border-radius: 5px; cursor: pointer;">✏️</button>
          <button onclick='eliminarLibro(${libro.id_libro})' style="padding: 5px 10px; font-size: 14px; background-color: #e74c3c; color: white; border: none; border-radius: 5px; cursor: pointer;">🗑️</button>
        </td>
      </tr>
    `;
  });

  html += `
          </tbody>
        </table>
      </div>
    </div>
  `;

  document.getElementById("contenido").innerHTML = html;
}


// Mostrar formulario para agregar/editar
function formularioLibro(libro = {}) {
  const esEdicion = !!libro.id_libro;

  document.getElementById("contenido").innerHTML = `
    <div style="display: flex; justify-content: center; align-items: center; min-height: 100vh;">
      <div style="background-color: rgba(255, 255, 255, 0.95); padding: 30px; border-radius: 15px; width: 90%; max-width: 600px; box-shadow: 0 0 10px rgba(0,0,0,0.2); font-size: 18px;">
        <h2 style="text-align: center; margin-bottom: 25px;">${esEdicion ? "✏️ Editar Libro" : "➕ Nuevo Libro"}</h2>
        <form onsubmit="guardarLibro(event, ${esEdicion ? libro.id_libro : null})" style="display: flex; flex-direction: column; gap: 15px;">
          <input required placeholder="Título" id="titulo" value="${libro.titulo || ""}" style="padding: 10px; font-size: 16px; border-radius: 8px; border: 1px solid #ccc;">
          <input required placeholder="Editorial" id="editorial" value="${libro.editorial || ""}" style="padding: 10px; font-size: 16px; border-radius: 8px; border: 1px solid #ccc;">
          <input required placeholder="Autor" id="autor" value="${libro.autor || ""}" style="padding: 10px; font-size: 16px; border-radius: 8px; border: 1px solid #ccc;">
          <input required placeholder="ISBN" id="isbn" value="${libro.isbn || ""}" style="padding: 10px; font-size: 16px; border-radius: 8px; border: 1px solid #ccc;">
          <input required placeholder="Año de publicación" type="number" id="anio" value="${libro.año_publi || ""}" style="padding: 10px; font-size: 16px; border-radius: 8px; border: 1px solid #ccc;">
          <input required placeholder="Género" id="genero" value="${libro.genero || ""}" style="padding: 10px; font-size: 16px; border-radius: 8px; border: 1px solid #ccc;">
          <input required placeholder="Unidades disponibles" type="number" id="unidades" value="${libro.unidDispo || ""}" style="padding: 10px; font-size: 16px; border-radius: 8px; border: 1px solid #ccc;">

          <button type="submit" style="padding: 12px; font-size: 16px; border: none; background-color: ${esEdicion ? "#f1c40f" : "#2ecc71"}; color: white; border-radius: 8px; cursor: pointer;">
            ${esEdicion ? "Actualizar" : "Agregar"}
          </button>
        </form>
      </div>
    </div>
  `;
}


// Guardar libro (nuevo o editado)
async function guardarLibro(e, id) {
  e.preventDefault();
  const libro = {
    titulo: document.getElementById("titulo").value,
    editorial: document.getElementById("editorial").value,
    autor: document.getElementById("autor").value,
    isbn: document.getElementById("isbn").value,
    anio_publicacion: parseInt(document.getElementById("anio").value),
    genero: document.getElementById("genero").value,
    unidades: parseInt(document.getElementById("unidades").value)
  };

  const url = id
    ? `http://localhost:8080/api/librosEditar?id_libro=${id}`
    : `http://localhost:8080/api/librosAgregar`;

  const method = id ? "POST" : "POST";

  await fetch(url, {
    method,
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(libro)
  });

  verLibros();
}

// Eliminar libro
async function eliminarLibro(id) {
  if (confirm("¿Seguro que deseas eliminar este libro?")) {
    await fetch(`http://localhost:8080/api/librosEliminar?id_libro=${id}`, { method: "GET" });
    verLibros();
  }
}

// Ver todos los préstamos
async function verPrestamos() {
  const response = await fetch("http://localhost:8080/api/prestamos"); // Asegúrate que esta ruta exista
  const prestamos = await response.json();

  let html = `
    <div style="display: flex; justify-content: center; align-items: center; min-height: 100vh;">
      <div style="background-color: rgba(255,255,255,0.95); padding: 30px; border-radius: 15px; width: 95%; max-width: 1200px; font-size: 18px; box-shadow: 0 0 10px rgba(0,0,0,0.2);">
        <h2 style="text-align: center; margin-bottom: 25px;">📋 Todos los Préstamos</h2>
        <table style="width: 100%; border-collapse: collapse; font-size: 16px;">
          <thead>
            <tr style="background-color: #f2f2f2;">
              <th style="padding: 10px; border: 1px solid #ccc;">👤 Lector</th>
              <th style="padding: 10px; border: 1px solid #ccc;">📚 Libro</th>
              <th style="padding: 10px; border: 1px solid #ccc;">📅 Fecha de Préstamo</th>
              <th style="padding: 10px; border: 1px solid #ccc;">🗓️ Fecha de Devolución</th>
            </tr>
          </thead>
          <tbody>
  `;

  prestamos.forEach(p => {
    html += `
      <tr>
        <td style="padding: 8px; border: 1px solid #ccc;">${p.lector}</td>
        <td style="padding: 8px; border: 1px solid #ccc;">${p.titulo}</td>
        <td style="padding: 8px; border: 1px solid #ccc;">${p.fechaRetiro}</td>
        <td style="padding: 8px; border: 1px solid #ccc;">${p.fechaEntrega}</td>
      </tr>
    `;
  });

  html += `
          </tbody>
        </table>
      </div>
    </div>
  `;

  document.getElementById("contenido").innerHTML = html;
}


// Cerrar sesión
function cerrarSesion() {
  localStorage.clear();
  window.location.href = "login.html";
}
