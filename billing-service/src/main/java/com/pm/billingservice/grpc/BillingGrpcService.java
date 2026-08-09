package com.pm.billingservice.grpc;

import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BillingGrpcService extends BillingServiceGrpc.BillingServiceImplBase {
    @Override
    public void createBillingAccount(billing.BillingRequest billingRequest,
                                     StreamObserver<billing.BillingResponse> responseObserver){

        log.info("createBillingAccount request received : {}", billingRequest.toString());

        //Business logic - e.g save to database, perform calculates etc

        BillingResponse billingResponse = BillingResponse.newBuilder()
                .setAccountId("12345")
                .setStatus("ACTIVE")
                .build();

        responseObserver.onNext(billingResponse);
        responseObserver.onCompleted();
    }
}
