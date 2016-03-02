package computations;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import computations.utils.Helper;
import computations.utils.RANSAC;

public class RansacTest
{
	@Test
	public void test_ransac()
	{
		// 5 8 11 14 17 20 23 26
		List<Double> data = new ArrayList<>();
		data.add(5.0);
		data.add(8.0);
		data.add(11.0);
		data.add(22.0);
		data.add(17.0);
		data.add(20.0);
		data.add(23.0);
		data.add(500.0);

		List<Double> res = RANSAC.perform(data, 2, 100, 1, 0.2);
		Assert.assertEquals(3.0, res.get(0), 0.01);
		Assert.assertEquals(2.0, res.get(1), 0.01);
	}

	@Test
	public void test_ransac_2()
	{
		// 2858 3591 4421 5456 6625 7950 9355 10887 12539 14336 16302 18387
		List<Double> data = new ArrayList<>();
		data.add(2858.0);
		data.add(3591.0);
		data.add(4421.0);
		data.add(5456.0);
		data.add(6625.0);
		data.add(7950.0);
		data.add(9355.0);
		data.add(10887.0);
		data.add(12539.0);
		data.add(14336.0);
		data.add(16302.0);
		data.add(18387.0);

		List<Double> diffs = Helper.computeDiff(data);
		diffs = Helper.convertToSeconds(diffs);

		// too random.
		List<Double> res = RANSAC.perform(diffs, 2, 1000, 1, 0.9);
		Assert.assertEquals(0.14, res.get(0), 1);
		Assert.assertEquals(0.50, res.get(1), 2);
	}
}
