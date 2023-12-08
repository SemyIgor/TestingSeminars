# import unittest
# import pytest
import pytest

from Maxaverage import Maxaverage


def test_find_average():
    numbers = [10, 20, 30, 40, 50]
    assert Maxaverage.find_average(numbers) == 30


def test_average_zero():
    # numbers = []
    assert Maxaverage.find_average([]) == 0

def test_average_alone():
    # numbers = [7]
    assert Maxaverage.find_average([7]) == 7


def test_average_not_number():
    string_list = ["c"]
    with pytest.raises(TypeError):
        Maxaverage.find_average(string_list)


def test_average_not_list():
    string_list = 10
    with pytest.raises(TypeError):
        Maxaverage.find_average(string_list)


def test_find_max_first():
    assert Maxaverage.find_max(30, 25) == "Первый список имеет большее среднее значение"


def test_find_max_second():
    assert Maxaverage.find_max(25, 30) == "Второй список имеет большее среднее значение"


def test_find_both_equal():
    assert Maxaverage.find_max(30, 30) == "Средние значения равны"


def test_find_max_second_integrated():
    numbers1 = [10, 20, 30, 40, 50]
    numbers2 = [15, 25, 35, 45, 55]
    assert (Maxaverage.find_max(Maxaverage.find_average(numbers1),
                                Maxaverage.find_average(numbers2)) ==
            "Второй список имеет большее среднее значение")
