<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<div>
	<div class="step-wizard step-2">
      <h3><span>Step 2:</span> Choose Your Event Type</h3>
    </div>
    <div class="overlay step-2">
      <img src="/eventEstimator/images/ic-x.png" class="close">
      <form method="POST" action="eventEstimator/steps/step1.j" class="venue-form">
        <label for="location">Event Location:</label>
        <input type="text" placeholder="-City/Town-" name="city" id="location">
        <select id="state" name="state">
          <optgroup>
            <option>-State/Zip-</option>
            <option>-New York/10010</option>
          </optgroup>
        </select>
        <label for="category">Event Category:</label>
        <select id="category" name="category">
          <optgroup>
            <option>-Category-</option>
            <option>Awesome Hackathon</option>
            <option>Conference</option>
            <option>Company Holiday Party</option>
            <option>Community Event</option>
          </optgroup>
        </select>
        <label for="category">Food Type:</label>
        <select id="food" name="food">
          <optgroup>
            <option>-Category-</option>
            <option>Modern American</option>
            <option>Vegetarian (Only)</option>
            <option>Italian</option>
            <option>Asian Fusion</option>
            <option>Chinese</option>
            <option>French</option>
          </optgroup>
        </select>
      <div class="venue">
        <input type="button" value="Find Venue Spot!" class="find-venue">
      </div>
      </form>
    </div>
</div>