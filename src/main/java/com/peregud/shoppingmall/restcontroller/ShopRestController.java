package com.peregud.shoppingmall.restcontroller;

import com.peregud.shoppingmall.domain.Shop;
import com.peregud.shoppingmall.dto.ShopDto;
import com.peregud.shoppingmall.payload.ApiResponse;
import com.peregud.shoppingmall.service.ShopRestService;
import com.peregud.shoppingmall.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.peregud.shoppingmall.AppConstants.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/shops")
public class ShopRestController {

    private final ShopRestService shopService;

    @GetMapping
    public ResponseEntity<Page<ShopDto>> getAll(
            @RequestParam(name = PAGE, required = false, defaultValue = DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(name = SIZE, required = false, defaultValue = DEFAULT_PAGE_SIZE) Integer size) {
        PageUtil.validatePageNumberAndSize(page, size);
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, ID);
        return shopService.getAll(pageable);
    }

    @PostMapping
    public ResponseEntity<Shop> addShop(@RequestBody Shop shop) {
        return shopService.save(shop);
    }

    @GetMapping(PAGE_ID)
    public ResponseEntity<ShopDto> getShop(@PathVariable(name = ID) Integer id) {
        return shopService.getShopById(id);
    }

    @PutMapping(PAGE_ID)
    public ResponseEntity<Shop> updateShop(@PathVariable(name = ID) Integer id, @RequestBody Shop newShop) {
        return shopService.update(id, newShop);
    }

    @DeleteMapping(PAGE_ID)
    public ResponseEntity<ApiResponse> deleteShop(@PathVariable(name = ID) Integer id) {
        return shopService.delete(id);
    }
}
