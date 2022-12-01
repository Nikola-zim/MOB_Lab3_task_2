package com.example.task_2

class Orders {
    var orders_list:MutableList<Order> = mutableListOf()
    var orders_list_summary:MutableList<Orders_summary> = mutableListOf()
    constructor(){
        orders_list_summary.add(Orders_summary("АИ-92", 0, 0F))
        orders_list_summary.add(Orders_summary("АИ-95", 0, 0F))
    }

    fun add_Order (new_order:Order){
        orders_list.add(new_order)
        var flar_new_octane = false
        //Проверка наличия в списке видов бензина и обновление резюмирующего списка
        for(elem in orders_list_summary){
            if (elem.octane == new_order.octane){
                elem.sum_amount += new_order.amount
                elem.sum_price += new_order.price * new_order.amount
                flar_new_octane = false
                break
            } else{
                flar_new_octane = true
            }
        }
        if(flar_new_octane){
            var _sum_price = new_order.price * new_order.amount
            orders_list_summary.add(Orders_summary(new_order.octane, new_order.amount, _sum_price))
        }

    }

    fun orders_info_get(): String {
        var summaryString = ""
        for(elem in orders_list_summary){
            summaryString += elem.octane + " | " + elem.sum_amount.toString() + " | " + elem.sum_price.toString() + "\n"
        }
        return summaryString
    }

    data class Order(val octane:String, val amount:Int, val price:Float)

    data class Orders_summary(val octane:String, var sum_amount:Int, var sum_price:Float)
}



