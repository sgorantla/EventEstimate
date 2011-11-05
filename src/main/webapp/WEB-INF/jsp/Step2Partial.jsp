<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<div>
	<div class="step-wizard step-2">
      <h3><span>Step 2:</span> Choose Your Event Type</h3>
    </div>
    <div class="overlay step-2">
      <img src="/eventEstimator/images/ic-x.png" class="close">
      <form method="POST" class="venue-form">
        <label for="location">Event Location:</label>
        <input type="text" placeholder="-City/Town-" name="location" id="location">
        <select id="state">
          <optgroup>
            <option>-State/Zip-</option>
          </optgroup>
        </select>
        <label for="category">Event Category:</label>
        <select id="category">
          <optgroup>
            <option>-Category-</option>
          </optgroup>
        </select>
        <label for="category">Food Type:</label>
        <select id="food">
          <optgroup>
            <option>-Food Type-</option>
          </optgroup>
        </select>
      </form>
      <div class="venue">
        <input type="submit" value="Find Venue Spot!" class="find-venue">
      </div>
    </div>
</div>