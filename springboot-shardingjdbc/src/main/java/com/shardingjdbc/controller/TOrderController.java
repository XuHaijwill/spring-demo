package com.shardingjdbc.controller;


import com.shardingjdbc.model.TOrder;
import com.shardingjdbc.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class TOrderController {

    @Autowired
    private TOrderService tOrderService;

    @PostMapping("/save")
    public String save(@RequestBody TOrder tOrder) {
        tOrderService.save(tOrder);
        return "success";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(value = "id") Integer id) {
        tOrderService.delete(id);
        return "success";
    }

    @PostMapping("/update")
    public int update(@RequestBody TOrder tOrder) {
        return tOrderService.update(tOrder);
    }

    @GetMapping("/getList")
    public List<TOrder> getList() {
        return tOrderService.getList();
    }
}
