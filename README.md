# BastionMCClans — 0.1.0-beta

Proyecto fuente para **Purpur 1.21.11 / Java 21**. Subir el contenido de esta carpeta a la raíz de GitHub y ejecutar Actions → Build BastionMCClans → Run workflow. El JAR se obtiene en Artifacts.

## Incluye en esta beta
- Crear clanes, solicitar ingreso, invitar y aceptar, rangos, liderazgo, salida y disolución confirmada.
- Alianzas mutuas y rivalidades mutuas (5 por clan), PvP interno, bloqueo de daño aliado.
- Tres niveles por días O kills; puntos de ranking por kills, muertes y días; anti-farming básico.
- Hasta tres bases por nivel, teletransporte retrasado que se cancela al moverse o recibir daño.
- Menú principal, cabezas de miembros, comandos, autocompletado, mensajes y menús YAML, colores HEX legacy.
- Datos persistentes en `plugins/BastionMCClans/clans-data.yml`.
- API Java `getClanPlaceholder(UUID)` para integrar en BastionMCNameTangs.

## Limitaciones conocidas (no usar como versión definitiva)
- La expansión de PlaceholderAPI y el parche a BastionMCNameTangs **todavía no están implementados**: el método Java de integración está disponible, pero `%bastionclans_player%` aún no se resuelve por sí solo.
- Menús de confirmación, perfiles, alianzas, solicitudes y bases todavía usan mensajes/comandos en algunas rutas; no son GUI completos.
- Falta la integración con Vault, las bases compartidas con aliados y estadísticas semanales reiniciables.
- El almacenamiento es YAML, no SQLite. La actualización de nametags en vivo requiere integración adicional.
- La mayoría de mensajes se editan en `messages.yml`, pero algunos textos de ayuda y avisos de esta beta están todavía en el código.
- El autocompletado es básico y necesita filtrado contextual adicional de permisos y rangos.
- No se ha probado en un servidor Purpur real. **Haz una copia de seguridad y prueba en un servidor de pruebas.**


## TAB / PlaceholderAPI

Instala PlaceholderAPI (PAPI) y TAB. Los placeholders están integrados en el JAR y se registran al arrancar, sin `/papi ecloud download`.

- `%bastionclans_name%`: nombre sin formato (vacío si no tiene clan).
- `%bastionclans_colored%`: nombre en el color configurado con `/clan colorname`, o `§8(§cSin Clan§8)` si no pertenece a ninguno.
- `%bastionclans_has_clan%`: `true` / `false`.

En `plugins/TAB/config.yml`, cambia la línea del scoreboard por:

```yaml
- " &e🛡 &fTu Clan: %bastionclans_colored%"
```

Si tienes dos definiciones de scoreboard, actualiza ambas. Usa `/tab reload` después de instalar y reiniciar el servidor.
No borres `plugins/BastionMCClans/clans-data.yml`: contiene los clanes existentes.
