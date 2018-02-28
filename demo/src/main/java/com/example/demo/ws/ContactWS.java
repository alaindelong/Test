package com.example.demo.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ContactDao;
import com.example.demo.model.Contact;

@RestController
@CrossOrigin("*")
public class ContactWS {

	@Autowired
	private ContactDao contactDao;
	
	@RequestMapping(value="/contacts", method=RequestMethod.GET)
	public List<Contact> getContacts(){
		return contactDao.findAll();
	}
	
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.GET)
	public Contact getContact(@PathVariable Long id){
		return contactDao.findOne(id);
	}
	
	@RequestMapping(value="/chercherContacts", method=RequestMethod.GET)
	public Page<Contact> chercherContact(@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="size",defaultValue="5") int size,
			@RequestParam(name="page",defaultValue="0") int page){
		return contactDao.chercher("%"+mc+"%", new PageRequest(page, size));
	}
	
	@RequestMapping(value="/contacts", method=RequestMethod.POST)
	public Contact saveContact(@RequestBody Contact c){
		return contactDao.save(c);
	}
	
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.DELETE)
	public boolean deleteContact(@PathVariable Long id){
		 contactDao.delete(id);
		 return true;
	}
	
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.PUT)
	public Contact saveContact(@PathVariable Long id,@RequestBody Contact c){
		c.setId(id);
		return contactDao.save(c);
	}
}
