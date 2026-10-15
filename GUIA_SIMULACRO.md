# Simulacro de Git en pareja: Lámpara

Duración: 1 hora (máximo 1 h 15). Todo se hace en silencio por chat o videollamada.
**A** = quien crea el repo. **B** = el compañero.

El código ya funciona. Lo que se practica es Git.

---

## Fase 0 · Preparación (10 min) — A

1. En GitHub: crear repo `simulacro-lampara`, **público, vacío** (sin README).
2. Settings → Collaborators → invitar a B. **B acepta desde el correo ya mismo.**
3. En IntelliJ: proyecto nuevo `simulacro-lampara` (Java, sin Maven está bien).
4. Revisar que el `.gitignore` tenga `.idea/` y `out/` (o `target/`).
5. Terminal:
   ```
   git init
   git add .gitignore
   git commit -m "Agregar gitignore"
   git branch -M main
   git remote add origin LINK
   git push -u origin main
   ```

---

## Fase 1 · Relevo (20 min) — simula el escenario A del quiz

**A** (primera "hora"):
1. Crear paquetes `excepciones`, `modelo`, `vista`.
2. Pegar `LamparaApagadaException` y `Lampara`. Ejecutar no hace falta todavía.
3. 💣 **Error a propósito:** hacer `git add` **solo de `Lampara.java`** (no de la excepción), commit y push.
4. Crear `ESTADO.md` con: hecho / falta / decisiones. Commit y push.
5. Avisar a B: "relevo".

**B** (segunda "hora"):
1. IntelliJ → **Get from VCS** → pegar el link → clonar.
2. Leer `ESTADO.md`.
3. Intentar compilar → **va a fallar**: falta `LamparaApagadaException`.
   👉 Diagnóstico: archivo que A nunca agregó. B se lo dice a A.
4. A arregla: `git status` (la ve en rojo), `add`, `commit`, `push`.
5. B: `git pull`. Ahora compila.
6. B pega `PanelLampara` y `VentanaLampara`, ejecuta, `add`, `commit`, `push`.

**Lección:** antes del relevo, `git status` no debe mostrar nada en rojo que importe.

---

## Fase 2 · Trabajo simultáneo (20 min) — simula el escenario B

Los dos hacen `git pull` primero.

### 💣 Escenario 1: push rechazado
1. **B** cambia el título de la ventana a `"Lámpara de B"`, commit y push.
2. **A**, sin hacer pull, cambia el texto del botón `"Apagar"` a `"Apagar ya"`, commit y push.
3. A ve `! [rejected] ... (fetch first)`.
4. A resuelve: `git pull` → `git push`. (Se mezcla solo porque tocaron archivos distintos.)

### 💣 Escenario 2: conflicto
1. Los dos hacen `git pull`.
2. **A** cambia en `Lampara`: `PASO_BRILLO = 25`. Commit y push.
3. **B**, sin pull, cambia la **misma línea**: `PASO_BRILLO = 10`. Commit y push → rechazado.
4. B hace `git pull` → **CONFLICTO** en `Lampara.java`.
5. B abre el archivo (o la ventana de conflictos de IntelliJ), escoge un valor con A, **borra las marcas** `<<<<<<<`, `=======`, `>>>>>>>`.
6. B: `git add Lampara.java` → `git commit` → `git push`.
7. A: `git pull`. Los dos tienen lo mismo.

### 💣 Escenario 3: pull con cambios sin guardar
1. A edita algo en `PanelLampara` **sin hacer commit**.
2. B cambia otra cosa del mismo archivo, commit y push.
3. A hace `git pull` → `Your local changes ... would be overwritten`.
4. A resuelve: commit primero, luego `pull`.

---

## Fase 3 · Rama de entrega (10 min)

El quiz pide una rama específica. Practíquenlo:
1. A: `git checkout -b ejercicio-lampara`
2. A: un cambio pequeño, commit, `git push -u origin ejercicio-lampara`.
3. B: `git fetch` → `git checkout ejercicio-lampara` → `git pull`.
4. 💣 B hace un commit **estando en `main`** sin darse cuenta. Lo detecta mirando la rama arriba en IntelliJ.
   (Para arreglarlo: `git checkout ejercicio-lampara` → `git cherry-pick ID_DEL_COMMIT`.)
5. Ambos verifican en GitHub que todo está en `ejercicio-lampara`.

---

## Al final (5 min)

Cada uno anota: **¿cuál error le dio más susto y qué comando lo arregló?**
Esa lista es su chuleta para el quiz.
