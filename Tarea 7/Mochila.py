def knapsack(pesos, valores, capacidad):
    n = len(valores)  # Número de objetos
    
    # Creamos una tabla de (n+1) x (capacidad+1)
    tabla = [[0 for x in range(capacidad + 1)] for y in range(n + 1)]
    
    # Llenamos la tabla de programación dinámica
    for i in range(1, n + 1):
        for w in range(1, capacidad + 1):
            if pesos[i - 1] <= w:
                tabla[i][w] = max(valores[i - 1] + tabla[i - 1][w - pesos[i - 1]], tabla[i - 1][w])
            else:
                tabla[i][w] = tabla[i - 1][w]
    
    # El valor máximo estará en tabla[n][capacidad]
    return tabla[n][capacidad]
while True:
    # Preguntamos al usuario la cantidad de objetos
    n = int(input("Introduce la cantidad de objetos: "))

    pesos = []
    valores = []

    # Recolectamos los pesos y valores de cada objeto
    for i in range(n):
        peso = int(input(f"Introduce el peso del objeto {i + 1}: "))
        valor = int(input(f"Introduce el valor del objeto {i + 1}: "))
        pesos.append(peso)
        valores.append(valor)

    # Preguntamos la capacidad de la mochila
    capacidad = int(input("Introduce la capacidad de la mochila: "))

    # Llamamos a la función
    resultado = knapsack(pesos, valores, capacidad)
    print(f"El valor máximo que se puede llevar en la mochila es: {resultado}")
    
    # Pregunta si el usuario desea repetir
    repetir = input("¿Deseas calcular otra cantidad? Si lo desea escribir, s  si quiere terminar escribir, n : ").lower()

    if repetir != 's':
        print("Gracias por usar el programa.")
        break
