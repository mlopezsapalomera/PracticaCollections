# PracticaCollections

## Justificación y Decisiones

Este proyecto ha sido diseñado para gestionar un carrito de compras en tiempo real, mostrando el precio de los productos a medida que se añaden. Se ha utilizado el patrón de diseño MVC para separar la lógica de negocio, la interfaz de usuario y el control de flujo.

### Decisiones Técnicas

1. **Uso de List**: Se ha utilizado la colección `List` para almacenar los productos debido a su flexibilidad y facilidad de uso en operaciones de inserción y acceso.

2. **Uso de Map**: Se ha utilizado la colección `Map` para gestionar el carrito de compras y evitar duplicados de productos con el mismo código de barras. Esto permite una búsqueda eficiente y evita la duplicación de productos.

3. **Interfaz Comparable y Comparator**: Se ha implementado la interfaz `Comparable` en la clase `Aliment` para ordenar los productos por fecha de caducidad. Además, se ha implementado la interfaz `Comparator` en la clase `Textil` para ordenar los productos por composición.

4. **Streams y Lambda Expressions**: Se han utilizado streams y expresiones lambda para simplificar y mejorar el código, especialmente en la búsqueda de productos por código de barras.

## Requisitos Técnicos

- Declarar getters y setters en todas las clases.
- Documentar todo el código adecuadamente.
- Implementar la interfaz `Comparable` y `Comparator`.
- Utilizar `Map` para gestionar el carrito de compras.
- Evitar duplicados de productos textiles con el mismo código de barras.
- Implementar una función de búsqueda de productos por código de barras utilizando streams y lambda expressions.