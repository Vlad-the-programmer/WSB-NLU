def calculate():
    try:
        print("Please type in the number of a math operation you would like to complete:")
        print("1. + for addition")
        print("2. - for subtraction")
        print("3. * for multiplication")
        print("4. / for division")

        operation = input("Enter choice (1/2/3/4): ")
        print(operation)
        number_1 = float(input('Please enter the first number: '))
        number_2 = float(input('Please enter the second number: '))

        if operation == '1':
            print(f'{number_1} + {number_2} = {number_1 + number_2}')

        elif operation == '2':
            print(f'{number_1} - {number_2} = {number_1 - number_2}')

        elif operation == '3':
            print(f'{number_1} * {number_2} = {number_1 * number_2}')

        elif operation == '4':
            if number_2 != 0:
                print(f'{number_1} / {number_2} = {number_1 / number_2}')
            else:
                print('Error: Cannot divide by zero.')

        else:
            print('You have not typed a valid operator, please run the program again.')

    except ValueError:
        print('Error: Please enter valid numeric values.')

calculate()
