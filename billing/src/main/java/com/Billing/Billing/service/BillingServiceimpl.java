package com.Billing.Billing.service;

import com.Billing.Billing.payload.BillingDto;
import com.Billing.Billing.entity.Billing;
import com.Billing.Billing.entity.Patient;
import com.Billing.Billing.exception.ResourceNotFoundException;
import com.Billing.Billing.repository.BillingRepository;
import com.Billing.Billing.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceimpl implements BillingService{

    private BillingRepository billingRepository;


    private PatientRepository patientRepository;

    private ModelMapper modelMapper;

    public BillingServiceimpl(BillingRepository billingRepository, PatientRepository patientRepository, ModelMapper modelMapper) {
        this.billingRepository = billingRepository;
        this.patientRepository = patientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BillingDto createBill(long patientId,BillingDto billingDto) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("patient", "id", patientId));
        Billing billing = mapToBilling(billingDto);
        billing.setPatient(patient);

        Billing newBill = billingRepository.save(billing);
        return mapToDto(newBill);
    }









    Billing mapToBilling(BillingDto commentDto){
        Billing billing = modelMapper.map(commentDto, Billing.class);

//        Comment comment=new Comment();
//        comment.setName(commentDto.getName());
//        comment.setEmail(commentDto.getEmail());
//        comment.setBody(commentDto.getBody());
        return billing;//comment object
    }
    BillingDto mapToDto(Billing billing){        //initialise the object

        BillingDto billingDto = modelMapper.map(billing, BillingDto.class);


//        CommentDto commentDto=new CommentDto();
//        commentDto.setId(comment.getId());
//        commentDto.setName(comment.getName());
//        commentDto.setEmail(comment.getEmail());
//        commentDto.setBody(comment.getBody());
//
        return billingDto;
    }
}
