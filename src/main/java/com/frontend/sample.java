package com.frontend;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import com.WE.WE_Sample;
import com.baseClass.Base;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class sample  extends Base{

	
	public static  void Servicewd() {
		WE_Sample sample = new WE_Sample(driver);
		
		
		WebElement draggableElement = driver.findElement(By.xpath("(//android.widget.SeekBar)[1]"));
		 
//		// Get the start and end X coordinates of the SeekBar
//		int startX = seekBar.getLocation().getX();
//		int endX = startX + seekBar.getSize().getWidth();
//		int yAxis = seekBar.getLocation().getY() + (seekBar.getSize().getHeight() / 2);
//
//		// Calculate the moveTo position (e.g., move to 50% of the SeekBar's width)
//		int moveTo = (int) (startX + (endX - startX) * 0.5);
//
//		// Debugging: Print coordinate details
//		System.out.println("startX: " + startX);
//		System.out.println("endX: " + endX);
//		System.out.println("yAxis: " + yAxis);
//		System.out.println("moveTo: " + moveTo);
//
//		// Use the W3C Actions API to perform the drag-and-drop operation
//		PointerInput touch = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//		Sequence dragAndDrop = new Sequence(touch, 1);
//
//		// Move to the start point and press
//		dragAndDrop.addAction(touch.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, yAxis));
//		dragAndDrop.addAction(touch.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//
//		// Drag to the target location (moveTo position)
//		dragAndDrop.addAction(touch.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), moveTo, yAxis));
//
//		// Release the touch
//		dragAndDrop.addAction(touch.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//
//		// Perform the action
//		driver.perform(Arrays.asList(dragAndDrop));
		
		
		
		
		
		// Get the SeekBar's location and dimensions
//		int startX = seekBar.getLocation().getX();
//		int seekBarWidth = seekBar.getSize().getWidth();
//		int yAxis = seekBar.getLocation().getY() + (seekBar.getSize().getHeight() / 2);
//
//		// Define the moveTo position (e.g., 50% of SeekBar's width)
//		int moveToX = (int) (startX + seekBarWidth * 0.5);
//
//		// Debug: Print coordinate information
//		System.out.println("SeekBar StartX: " + startX);
//		System.out.println("SeekBar Width: " + seekBarWidth);
//		System.out.println("SeekBar Y Axis: " + yAxis);
//		System.out.println("MoveToX: " + moveToX);
//
//		// Use W3C Actions API to perform drag operation
//		PointerInput touch = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//		Sequence dragSeekBar = new Sequence(touch, 0);
//
//		// Step 1: Move to the SeekBar start position and press down
//		dragSeekBar.addAction(touch.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, yAxis));
//		dragSeekBar.addAction(touch.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//
//		// Step 2: Gradually move towards the desired position
//		dragSeekBar.addAction(touch.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), moveToX, yAxis));
//
//		// Step 3: Release the press
//		dragSeekBar.addAction(touch.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//
//		// Perform the sequence
//		driver.perform(Arrays.asList(dragSeekBar));
		
		

		// Get the element's width and height
		int elementWidth = draggableElement.getSize().getWidth();
		int elementHeight = draggableElement.getSize().getHeight();

		// Calculate the target position (e.g., move to the right edge of the element)
		int targetX = (int) (elementWidth * 0.9); // Adjust percentage for the desired move
		int centerY = elementHeight / 2; // Vertical center of the element

		// Debug: Log element dimensions and target position
		System.out.println("Element Width: " + elementWidth);
		System.out.println("Element Height: " + elementHeight);
		System.out.println("Target X (relative to element): " + targetX);
		System.out.println("Center Y (relative to element): " + centerY);

		// Use the W3C Actions API for the drag operation
		PointerInput touch = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence dragElement = new Sequence(touch, 0);

		// Step 1: Move to the element's starting position and press down (relative to the element)
		dragElement.addAction(touch.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.fromElement(draggableElement), 0, centerY));
		dragElement.addAction(touch.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

		// Step 2: Drag to the right side of the element
		dragElement.addAction(touch.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.fromElement(draggableElement), targetX, centerY));

		// Step 3: Release the press
		dragElement.addAction(touch.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		// Perform the drag operation
		driver.perform(Arrays.asList(dragElement));
		
		
		
		
		
		
		
//		int seekBarStartX = seekBar.getLocation().getX();
//		int seekBarEndX = seekBarStartX + seekBar.getSize().getWidth();
//		int seekBarY = seekBar.getLocation().getY() + (seekBar.getSize().getHeight() / 2);
//
//		// Define the target position (e.g., move to 50% of the SeekBar's width)
//		int moveToX = (int) (seekBarStartX + (seekBarEndX - seekBarStartX) * 0.5); // Adjust as per your need
//
//		// Debug: Log SeekBar details for verification
//		System.out.println("SeekBar Start X: " + seekBarStartX);
//		System.out.println("SeekBar End X: " + seekBarEndX);
//		System.out.println("SeekBar Y: " + seekBarY);
//		System.out.println("MoveTo X: " + moveToX);
//
//		// Use the W3C Actions API for the drag operation
//		PointerInput touch = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//		Sequence dragSeekBar = new Sequence(touch, 0);
//
//		// Step 1: Move to the SeekBar start position and press down
//		dragSeekBar.addAction(touch.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), seekBarStartX, seekBarY));
//		dragSeekBar.addAction(touch.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//
//		// Step 2: Move to the desired position on the SeekBar
//		dragSeekBar.addAction(touch.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), moveToX, seekBarY));
//
//		// Step 3: Release the press
//		dragSeekBar.addAction(touch.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//
//		// Perform the action
//		driver.perform(Arrays.asList(dragSeekBar));
	}
	
	
}
