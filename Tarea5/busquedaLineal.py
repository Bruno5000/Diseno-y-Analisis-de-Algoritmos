#Busqueda lineal
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

def busqueda_lineal(arr, valor):
    for i in range(len(arr)):
        if arr[i] == valor:
            return i
    return -1  # Valor no encontrado

# Ejemplo de uso
datos = [0.78, 0.45, 0.29, 0.67, 0.15, 0.88]
datos_ordenados = bucket_sort(datos)
print("Datos ordenados:", datos_ordenados)
valor_buscado = 0.67
indice = busqueda_lineal(datos_ordenados, valor_buscado)
print(f"Valor {valor_buscado} encontrado en el índice {indice}")
