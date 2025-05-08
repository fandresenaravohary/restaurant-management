package com.restaurantManagement.mapper;

import com.restaurantManagement.dto.OrderDto;
import com.restaurantManagement.models.Menu;
import com.restaurantManagement.models.Order;
import com.restaurantManagement.models.TableRestaurant;
import com.restaurantManagement.repository.MenuRepository;
import com.restaurantManagement.repository.TableRestaurantRepository;
import com.restaurantManagement.summarized.OrderSummarized;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final TableRestaurantRepository tableRestaurantRepository;
    private final MenuRepository menuRepository;

    public OrderSummarized convertToOrderSummarized(Order order) {
        if (order == null) {
            return null;
        }
        return OrderSummarized.builder()
                .id(order.getId())
                .tableNumber(order.getTable() != null ? order.getTable().getNumberTable() : 0)
                .menuName(order.getMenu() != null ? order.getMenu().getName() : null)
                .quantity(order.getQuantity())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build();
    }

    public Order convertToOrder(OrderDto orderDto) {
        if (orderDto == null) {
            return null;
        }

        Menu menuId = menuRepository.findById(orderDto.getMenuId())
                .orElseThrow(() -> new RuntimeException("Menu not found for id " + orderDto.getMenuId()));

        TableRestaurant tableId = tableRestaurantRepository.findById(orderDto.getTableId())
                .orElseThrow(() -> new RuntimeException("Table not found for id " + orderDto.getTableId()));

        return Order.builder()
                .id(orderDto.getId())
                .menu(menuId)
                .table(tableId)
                .price(orderDto.getPrice())
                .build();
    }
}
