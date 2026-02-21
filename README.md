# Sistema de Turnos 📋

Un sistema caótico pero funcional para gestionar turnos en una cola. ¡Porque a veces necesitas un poco de orden en el caos!

## ¿Qué es esto?

Un programa en Java que simula un sistema de gestión de turnos. Puedes registrar turnos, atenderlos, cancelarlos, insertar urgentes, y ver estadísticas de todo el desorden que estás creando.

## Características 🎯

- **Registrar turnos** ➕ - Entra en la fila como un mortal normal
- **Atender siguiente** ▶️ - Que pase el siguiente pobre de la cola
- **Cancelar turnos** ❌ - Yeetea un turno al olvido
- **Turnos urgentes** 🚨 - Cúelate en la fila (URGENTE!!!)
- **Ver estadísticas** 📊 - Mira cuanto caos hay
- **Ver cola** 📋 - Voyeurismo puro, mira quien está sufriendo

## Cómo usar 🚀

### Compilar
```bash
javac -d out src/Classes/*.java src/Main.java
```

### Ejecutar
```bash
java -cp out Main
```

### El flujo
1. Inicia el programa
2. Indica cuántos turnos max pueden entrar
3. Elige una opción del menú
4. Sigue las instrucciones (son bastante obvias)
5. Cuando te canses, salite (opción 0)

## Opciones del menú

| Opción | Qué hace | Emoji |
|--------|----------|-------|
| 1 | Registrar un turno nuevo | ➕ |
| 2 | Atender al siguiente | ▶️ |
| 3 | Cancelar un turno | ❌ |
| 4 | Insertar turno urgente | 🚨 |
| 5 | Ver estadísticas | 📊 |
| 6 | Ver la cola completa | 📋 |
| 0 | Escapar de aquí | 🚪 |

## Tipo de turno

- **P** = Preferencial (VIP energy)
- **G** = General (el común de la gente)

## Estructura del proyecto

```
Punto2/
├── src/
│   ├── Main.java              (la interfaz caótica)
│   └── Classes/
│       ├── ManejoTurnos.java  (la lógica seria)
│       └── Turno.java         (el modelo)
├── README.md                  (este archivo)
└── Punto2.iml                 (config de IntelliJ)
```

## Notas importantes ⚠️

- El sistema validará que uses números donde corresponde (no ficción científica)
- Los turnos tienen un ID que se auto-incrementa (no te preocupes por eso)
- La capacidad máxima es lo que defines al inicio (después no la cambias)
- Si intentas algo ilegal (mala posición, ID inexistente, etc), el sistema te lo dirá

## Ejemplo de uso

```
Cuantos turnos entran? (capacidad): 5
✅ Dale! Sistema listo para el caos con 5 turnos

--- MENU TURNOS (choose wisely) ---
1. ➕ Registrar turno (entra en la fila)
2. ▶️ Atender siguiente (que pase el siguiente pobre)
3. ❌ Cancelar turno (yeet el turno)
4. 🚨 Insertar turno urgente (URGENTE!!! URGENTE!!!)
5. 📊 Estadísticas (que se vea cuanto caos hay)
6. 📋 Mostrar cola (a ver quien esta ahi sufiendo)
0. 🚪 Salir (escapar de aqui)
>> 1
Tipo (P preferencial / G general): P
Tiempo estimado (1-60 minutos): 30
✅ Turno #1 registrado! que vueltas da la vida eh
```

## Errores comunes 🤦

| Error | Causa | Solución |
|-------|-------|----------|
| "Tipo? cual tipo? pon algo" | No escribiste nada | Pon P o G boludo |
| "Ey, pon números! no ficción científica" | Pusiste letras donde van números | Números enteros only |
| "Ese ID no existe boludo" | Intentaste cancelar un turno que no existe | Mira la cola primero |
| "oof, no se pudo" | La posición está fuera de rango | La fila no es tan larga |

## Autor 👨‍💻

Hecho con cierto grado de caos y muy poco sueño.

---

**Enjoy the chaos!** 🎉

