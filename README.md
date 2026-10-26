# Taller práctico: Simulador de descuentos con Quarkus
**Programación Avanzada II | Unidad 1**  
**Estudiante:** Fabricio Topón  

---

## Preguntas de análisis

### 1. ¿En qué parte del ejercicio se aplica IoC y en cuál DI?
* **IoC (Inversión de Control):** Se aplica al delegar la creación, ciclo de vida y administración de los componentes (`DescuentoRegular`, `DescuentoVIP`, `Auditoria`, `VentaService`) al contenedor ArC de Quarkus, sin necesidad de instanciarlos manualmente con `new`.
* **DI (Inyección de Dependencias):** Se aplica en `VentaService` al suministrarle sus dependencias mediante dos técnicas:
  * Inyección por atributo: `@Inject @Named("regular") private CalculadoraDescuento descuentoRegular;` y `@Named("vip")`.
  * Inyección por constructor: `@Inject public VentaService(Auditoria auditoria)`.

### 2. ¿Qué función cumplen los Qualifiers y por qué son necesarios?
Los Qualifiers (como `@Named`) sirven para resolver la ambigüedad de tipos. Son necesarios cuando una misma interfaz (`CalculadoraDescuento`) tiene múltiples implementaciones (`DescuentoRegular` y `DescuentoVIP`), permitiendo al contenedor CDI identificar exactamente cuál implementación inyectar en cada caso.

### 3. ¿Cuál es la diferencia entre `@ApplicationScoped` y `@Dependent`?
* **`@ApplicationScoped`:** Crea una única instancia compartida durante toda la vida de la aplicación (comportamiento tipo Singleton administrado).
* **`@Dependent`:** No tiene un ciclo de vida propio; su ciclo de vida depende directamente del componente donde fue inyectado (se crea junto con él y se destruye con él).

### 4. ¿Por qué las instancias `@ApplicationScoped` pueden reutilizarse entre varias ventas?
Porque el contenedor ArC mantiene una única instancia en memoria para toda la aplicación. Al procesar varias ventas en `VentaService`, las operaciones invocan la misma instancia existente de la calculadora correspondiente, lo cual se evidencia al ver que el UUID se mantiene idéntico entre ventas del mismo tipo.

### 5. ¿Qué sucedería si se elimina el Qualifier de un punto de inyección de `CalculadoraDescuento`?
Quarkus detectará un error de resolución ambigua (`AmbiguousResolutionException`) en tiempo de compilación. Como existen dos beans válidos para la interfaz `CalculadoraDescuento` y ninguno tiene distinción, ArC no sabrá cuál inyectar y la aplicación no compilará.
