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

def busqueda_centinela(arr, valor):
    n = len(arr)
    ultimo = arr[n - 1]
    arr[n - 1] = valor
    i = 0

    while arr[i] != valor:
        i += 1

    arr[n - 1] = ultimo  # Restaurar el último valor

    if i < n - 1 or arr[n - 1] == valor:
        return i
    else:
        return -1  # Valor no encontrado

# Ejemplo de uso
datos = [0.78, 0.45, 0.29, 0.67, 0.15, 0.88]
valor_buscado = 0.67

# Aplicar bucket sort
datos_ordenados = bucket_sort(datos)
print("Datos ordenados:", datos_ordenados)

# Búsqueda con centinela
indice_centinela = busqueda_centinela(datos_ordenados, valor_buscado)
print(f"Valor {valor_buscado} encontrado en el índice {indice_centinela} (búsqueda de centinela)")
