class Maxaverage:
    @staticmethod
    def find_average(numbers):
        if not isinstance(numbers, list):
            raise TypeError("Input should be a list")
        if not numbers:
            return 0
        return sum(numbers) / len(numbers)


    @staticmethod
    def find_max(a, b):
        if a > b:
            result = "Первый список имеет большее среднее значение"
        elif a == b:
            result = "Средние значения равны"
        else:
            result = "Второй список имеет большее среднее значение"
        print("\n" + result)
        return result
