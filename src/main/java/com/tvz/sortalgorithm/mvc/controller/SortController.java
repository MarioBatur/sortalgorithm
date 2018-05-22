package com.tvz.sortalgorithm.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tvz.sortalgorithm.mvc.model.SortHelper;

@Controller
@RequestMapping("/sort")
public class SortController {

	@RequestMapping(value = "generate/{n}", method = RequestMethod.POST)
	@ResponseBody
	public List<Integer> generateRandomNumbers(@PathVariable int n) {
		Random random = new Random();
		List<Integer> listaRandomBrojeva = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			listaRandomBrojeva.add(random.nextInt(999));
		}
		return listaRandomBrojeva;
	}

	@RequestMapping(value = "sortiraj", method = RequestMethod.POST)
	@ResponseBody
	public List<List<Integer>> sortirajBrojeve(@RequestBody SortHelper sortHelper) {
		List<List<Integer>> listaZaispis = new ArrayList<>();
		for (int i = 0; i <= sortHelper.getLista().size(); i++) {
			for (int j = 1; j < sortHelper.getLista().size() - i; j++) {
				int privremenaVar;
				int x = sortHelper.getLista().get(j - 1);
				int y = sortHelper.getLista().get(j);
				if (x > y) {
					privremenaVar = x;
					sortHelper.getLista().remove(j - 1);
					sortHelper.getLista().add(j - 1, y);
					sortHelper.getLista().remove(j);
					sortHelper.getLista().add(j, privremenaVar);
					List<Integer> tmp = new ArrayList<>();
					for (Integer br : sortHelper.getLista()) {
						tmp.add(br);
					}
					listaZaispis.add(tmp);
				}
			}
		}
		return listaZaispis;
	}
}
