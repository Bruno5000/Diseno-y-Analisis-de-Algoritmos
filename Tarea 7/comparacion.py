def main():
    # Solicitar al usuario que ingrese el array A
    array_input = input("Introduce los números del array A separados por comas: ")
    array_A = [int(num) for num in array_input.split(",")]

    # Solicitar al usuario que ingrese el patrón P
    pattern_input = input("Introduce los números del patrón P separados por comas: ")
    pattern_P = [int(num) for num in pattern_input.split(",")]

    # Llamar a la función para verificar si el patrón aparece en el array
    if contains_pattern(array_A, pattern_P):
        print("El patrón P aparece en el array A.")
    else:
        print("El patrón P no aparece en el array A.")

def contains_pattern(array_A, pattern_P):
    # Convertir el patrón P a una cadena para facilitar la comparación
    pattern_str = ','.join(map(str, pattern_P))
    
    # Convertir el array A a una cadena
    array_str = ','.join(map(str, array_A))
    
    # Verificar si el patrón aparece en el array
    return pattern_str in array_str

if __name__ == "__main__":
    main()
