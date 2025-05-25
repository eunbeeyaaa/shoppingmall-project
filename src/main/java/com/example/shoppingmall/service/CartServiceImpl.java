package com.example.shoppingmall.service;

import com.example.shoppingmall.entity.Cart;
import com.example.shoppingmall.repository.CartRepository;
import com.example.shoppingmall.repository.MenuRepository;
import com.example.shoppingmall.repository.MemberRepository;
import com.example.shoppingmall.entity.Menu;
import com.example.shoppingmall.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final MenuRepository menuRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, MenuRepository menuRepository, MemberRepository memberRepository) {
        this.cartRepository = cartRepository;
        this.menuRepository = menuRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public void addItem(Long memberId, Long menuId, int quantity, String color, String size) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new NoSuchElementException("Menu not found"));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NoSuchElementException("Member not found"));

        Cart cart = new Cart();
        cart.setMember(member);
        cart.setMenu(menu);
        cart.setQuantity(quantity);
        cart.setColor(color);
        cart.setSize(size);

        cartRepository.save(cart);
    }

    @Override
    public void removeItem(Long memberId, Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new NoSuchElementException("Menu not found"));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NoSuchElementException("Member not found"));

        cart.setMember(member);
        //cart.setId(cartId);

        cartRepository.delete(cart);
    }

    @Override
    public List<Cart> getCartItemsByMember(Long memberId) {
        return cartRepository.findByMemberId(memberId);
    }
}
