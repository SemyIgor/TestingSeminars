from unittest import TestCase
from unittest.mock import Mock

import pytest

from tasks import Tasks

# Задание 1
def test_average():
    numbers = [10, 20, 30, 40, 50]
    assert Tasks.find_average(numbers) == 30

def test_average_zero():
    numbers = []
    assert Tasks.find_average(numbers) == 0

def test_average_alone():
    numbers = [7]
    assert Tasks.find_average(numbers) == 7

# Задание 2

def test_average_not_list():
    # string_list = ["10", "20", "30", "40", "50"]
    string_list = 10
    with pytest.raises(TypeError):
        Tasks.find_average(string_list)

# Задание 3

def test_check_receive_money():
    person = Tasks.Person(200)
    bank = Tasks.Bank()

    person.transfer_money(150, bank)
    assert person.balance == 50
    assert bank.balance == 150

def test_check_receive_money_not():
    person = Tasks.Person(150)
    bank = Tasks.Bank()

    with pytest.raises(ValueError):
        person.transfer_money(200, bank)

# Задание 4
def test_check_receive_money_mock():
    bank = Mock()
    person = Tasks.Person(200)
    person.transfer_money(150, bank)

    # bank.assert_called_with(bank(50))

    bank.receive_money.assert_called_with(150)

# Задание 5

def test_division_zero():

    with pytest.raises(ZeroDivisionError):
        Tasks.divide(10, 0)

# Задание 6
@pytest.mark.parametrize("a, b, expected", [
    (10,0,0), (2,3,6), (-2, 10, -20)])
def test_mult(a, b, expected):
    assert Tasks.multiply(a, b) == expected

# Задание 7
# (На семинаре не делали)

def test_len_string():
    assert len("Geek") == 4  # Строка из 4 символов

    assert len("") == 0  # Пустая строка

    assert len(" ") == 1  # Строка из одного пробельного символа

    assert len("Hello, World!") == 13  # Строка с пробелами и знаками препинания


# Задание 8
# проверяется в терминале

# Задание 9
@pytest.mark.parametrize("test_input, expected", [
    (2, True), (11, True), (6, False)])
def test_is_prime_positive(test_input, expected):
    assert Tasks.is_prime(test_input) == expected
