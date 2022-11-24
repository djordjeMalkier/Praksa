package common.bankarskiSistem.controller;

import common.bankarskiSistem.service.BankService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="/bank")
@RequiredArgsConstructor
@RestController
public class BankController {

    @NonNull
    private final BankService bankService;
}
