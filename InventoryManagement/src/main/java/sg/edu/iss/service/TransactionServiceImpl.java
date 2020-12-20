package sg.edu.iss.service;

import java.time.LocalDate;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.model.Car;
import sg.edu.iss.model.Transaction;
import sg.edu.iss.repo.CarRepository;
import sg.edu.iss.repo.ConsumptionRepository;
import sg.edu.iss.repo.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository tranrepo;
	
	@Autowired
	ConsumptionRepository conrepo;
	
	@Autowired
	CarRepository carepo;
	
	@Override
	public List<Transaction> findTransactionByDateRange(LocalDate start, LocalDate end) {
		return tranrepo.findTransactionByDateRange(start, end);
	}

	@Override
	public boolean saveTransaction(Transaction transaction) {
		if(tranrepo.save(transaction)!=null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Car findCarbyId(int Id) {
		return carepo.findById(Id).get();	
	}

	@Override
	public Transaction findLatestTransaction() {
		List<Transaction> transactions = tranrepo.findlatestTransaction();
		Transaction latesttransaction= transactions.get(0);
		return latesttransaction;
	}
	
}