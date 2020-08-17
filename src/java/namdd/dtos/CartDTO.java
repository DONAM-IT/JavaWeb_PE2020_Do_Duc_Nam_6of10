/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namdd.dtos;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author namdo
 */
public class CartDTO {

    private Map<String, ProductDTO> cart;

    public CartDTO() {
    }

    public CartDTO(Map<String, ProductDTO> cart) {
        this.cart = cart;
    }

    public Map<String, ProductDTO> getCart() {
        return cart;
    }

    public void add(ProductDTO dto) {

        if (this.cart == null) {
            cart = new HashMap<>();
        }
        if (this.cart.containsKey(dto.getProductID())) {
            int amount = this.cart.get(dto.getProductID()).getAmount();
            dto.setAmount(amount + 1);
        }
        this.cart.put(dto.getProductID(), dto);
    }

}
