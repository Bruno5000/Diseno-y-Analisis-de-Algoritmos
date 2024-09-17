def bucket_sort(arr):
    n = len(arr)
    if n <= 0:
        return arr

    # Crear n buckets vacíos
    buckets = [[] for _ in range(n)]

    # Distribuir los elementos en los buckets
    for elem in arr:
        index = int(n * elem)  # Asignar elementos a los buckets
        if index < n:  # Para evitar índices fuera de rango
            buckets[index].append(elem)

    # Ordenar cada bucket individualmente
    for bucket in buckets:
        bucket.sort()

    # Combinar todos los buckets ordenados en un solo arreglo
    sorted_array = []
    for bucket in buckets:
        sorted_array.extend(bucket)

    return sorted_array


def busqueda_binaria(arr, valor, inicio=0, fin=None):
    if fin is None:
        fin = len(arr) - 1

    if inicio > fin:
        return None  # Valor no encontrado

    central = (inicio + fin) // 2

    if arr[central] == valor:
        return arr[central]
    elif valor < arr[central]:
        return busqueda_binaria(arr, valor, inicio, central - 1)
    else:
        return busqueda_binaria(arr, valor, central + 1, fin)


# Ejemplo de uso
datos = [0.23, 0.15, 0.78, 0.32, 0.54, 0.11, 0.94]

# Ordenar la lista usando bucket sort
datos_ordenados = bucket_sort(datos)
print(f"Lista ordenada: {datos_ordenados}")

# Hacer la búsqueda binaria en la lista ordenada
valor_buscado = 0.54
resultado = busqueda_binaria(datos_ordenados, valor_buscado)

if resultado is not None:
    print(f"Valor {valor_buscado} encontrado en la lista.")
else:
    print(f"Valor {valor_buscado} no encontrado en la lista.")

#Bucket sort: 
#O(n2) en promedio.
#Busqueda lineal
#O(logn).
