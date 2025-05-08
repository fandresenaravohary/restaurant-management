package com.restaurantManagement.mapper;

import com.restaurantManagement.dto.TableRestaurantDto;
import com.restaurantManagement.models.TableRestaurant;
import com.restaurantManagement.summarized.TableRestaurantSummarized;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TableRestaurantMapper {

    public TableRestaurantSummarized convertTableRestaurantSummarized(TableRestaurant tableRestaurant) {
        if (tableRestaurant == null) {
            return null;
        }
        return TableRestaurantSummarized.builder()
                .id(tableRestaurant.getId())
                .numberTable(tableRestaurant.getNumberTable())
                .capacityMax(tableRestaurant.getCapacityMax())
                .status(tableRestaurant.getStatus())
                .createdAt(tableRestaurant.getCreatedAt())
                .updatedAt(tableRestaurant.getUpdatedAt())
                .build();
    }

    public TableRestaurant convertTableRestaurant(TableRestaurantDto tableRestaurantDto){
        if (tableRestaurantDto == null){
            return null;
        }
        return TableRestaurant.builder()
                .id(tableRestaurantDto.getId())
                .numberTable(tableRestaurantDto.getNumberTable())
                .capacityMax(tableRestaurantDto.getCapacityMax())
                .build();
    }
}
