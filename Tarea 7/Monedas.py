def calcular_monedas(cantidad):
    # Tipos de monedas
    monedas = [10, 5, 2, 1]
    cantidad_monedas = [0, 0, 0, 0]  # Inicializa la cantidad de cada moneda

    # Calcula cuántas monedas de 10 se necesitan
    if cantidad >= monedas[0]:
        cantidad_monedas[0] = cantidad // monedas[0]
        cantidad = cantidad % monedas[0]

    # Calcula cuántas monedas de 5 se necesitan del resto
    if cantidad >= monedas[1]:
        cantidad_monedas[1] = cantidad // monedas[1]
        cantidad = cantidad % monedas[1]

    # Calcula cuántas monedas de 2 se necesitan del resto
    if cantidad >= monedas[2]:
        cantidad_monedas[2] = cantidad // monedas[2]
        cantidad = cantidad % monedas[2]

    # Calcula cuántas monedas de 1 se necesitan del resto
    if cantidad >= monedas[3]:
        cantidad_monedas[3] = cantidad // monedas[3]
        cantidad = cantidad % monedas[3]

    # Imprime el resultado
    print(f"Monedas utilizadas:")
    print(f"{cantidad_monedas[0]} moneda(s) de 10")
    print(f"{cantidad_monedas[1]} moneda(s) de 5")
    print(f"{cantidad_monedas[2]} moneda(s) de 2")
    print(f"{cantidad_monedas[3]} moneda(s) de 1")


# Bucle para repetir el programa si el usuario lo desea
while True:
    # Pide al usuario la cantidad
    cantidad = int(input("Introduce la cantidad de dinero: "))
    calcular_monedas(cantidad)

    # Pregunta si el usuario desea repetir
    repetir = input("¿Deseas calcular otra cantidad? Si lo desea escribir, s  si quiere terminar escribir, n : ").lower()

    if repetir != 's':
        print("Gracias por usar el programa.")
        break
