import random

ASCII_A = 97
ASCII_Z = 122

#1
def main():
    famous_computer_scientist()
    combine_into_list(3,1000,23)
    list_of_numbers(10)
    list_of_letters()
    odd_numbers(20)
    user_numbers(5)
    snacks_list()
    order_total()

#2
def famous_computer_scientist():
    names = ["Alan Turing", "Grace Hopper", "Jim Gray", "Margaret Hamilton"]
    for n in names:
        print(n)
#3
def combine_into_list(num1, num2, num3):
    numbers = [num1, num2, num3]
    for n in numbers:
        print(n)
#4
def list_of_numbers(num):
    numbers = list(range(0,num+1))
    for n in numbers:
        print(n)
#5
def list_of_letters():
    letters = []
    for n in range(ASCII_A, ASCII_Z+1):
        letters.append(chr(n))
    for l in letters:
        print(l)
#6
def odd_numbers(upper_bound):
    numbers = list(range(1,upper_bound,2))
    for i in range(1, len(numbers), 2):
        print(numbers[i])
#7    
def user_numbers(number):
    numbers = [-1] * number
    for i in range(0, number):
        user_num = int(input("Enter a number ("+str(i+1) +" of " +str(number) +"): "))
        numbers[i] = user_num
    for num in numbers:
        print(num)
#8
def snacks_list():
    sweet = ["M&Ms", "Snickers", "Kit Kat"]
    salty = ["pretzels", "chips", "jerky"]
    snacks = sweet + salty
    for snack in snacks:
        print(snack)
#9
def order_total():
    prices = [1.10, 2.50, 6.45]
    quantities = [0] * 3
    order_total = 0
    for i in range(0, len(quantities)):
        quantities[i] = random.randint(1,10)

    for i in range(0,len(prices)):
        order_total += prices[i] * quantities[i]
    print("Order total: ", order_total)
main()