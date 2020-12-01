package com.gil.catalog;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("items")
@CrossOrigin(origins="http://localhost:4200")
public class ItemController
{
	private ItemRepository itemRepo;
	
	
	public ItemController(ItemRepository itemRepo)
	{
		this.itemRepo=itemRepo;
	}
	
	
	@GetMapping("get-all-items")
	public List<Item> getAllItems()
	{
		return itemRepo.findAll();
	}
	
	@GetMapping("/get-item/{no}")
	public Item getItem(@PathVariable int no) throws ItemDoesntExistsException
	{
		return itemRepo.findById(no).orElseThrow(ItemDoesntExistsException::new);
	}
	
	@PutMapping("/withdrawal-qty/{no}/{withdrawal}")
	public int withdrawalQty(@PathVariable int no, @PathVariable int withdrawal)
			throws ItemDoesntExistsException
	{
		Item item=itemRepo.findById(no).orElseThrow(ItemDoesntExistsException::new);
		
		item.setQty(item.getQty()-withdrawal);
		itemRepo.save(item);
		
		return item.getQty();
	}
	
	@PutMapping("/deposit-qty/{no}/{deposit}")
	public int depositQty(@PathVariable int no, @PathVariable int deposit)
			throws ItemDoesntExistsException
	{
		Item item=itemRepo.findById(no).orElseThrow(ItemDoesntExistsException::new);
		
		item.setQty(item.getQty()+deposit);
		itemRepo.save(item);
		
		return item.getQty();
	}
	
	@PostMapping("/add-item")
	public void addItem(@RequestBody Item item)
	{
		itemRepo.save(item);
	}
	
	@DeleteMapping("/delete-item/{no}")
	public String deleteItem(@PathVariable int no) throws ItemDoesntExistsException
	{
		Item item=itemRepo.findById(no).orElseThrow(ItemDoesntExistsException::new);
		String name=item.getName();
		
		itemRepo.deleteById(no);
		
		return name;
	}
}